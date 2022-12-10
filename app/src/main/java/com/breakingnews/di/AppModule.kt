package com.breakingnews.di

import com.breakingnews.data.api.MoshiArrayListJsonAdapter
import com.breakingnews.data.api.NewsApi
import com.breakingnews.data.mapper.NewsResponseToArticlesMapper
import com.breakingnews.data.repository.NewsRepository
import com.breakingnews.data.repository.NewsRepositoryImpl
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.breakingnews.domain.usecase.getarticles.GetArticlesUseCase
import com.breakingnews.domain.usecase.getarticles.GetArticlesUseCaseImpl
import com.breakingnews.ui.screen.home.HomeViewModel
import com.breakingnews.ui.screen.home.HomeViewModelImpl
import com.breakingnews.ui.screen.info.InfoViewModel
import com.breakingnews.ui.screen.info.InfoViewModelImpl
import com.breakingnews.ui.screen.menu.MenuViewModel
import com.breakingnews.ui.screen.menu.MenuViewModelImpl
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

// TODO: separate by diff modules 
val appModules = module {
    viewModelOf(::HomeViewModelImpl) { bind<HomeViewModel>() }
    viewModelOf(::InfoViewModelImpl) { bind<InfoViewModel>() }
    viewModelOf(::MenuViewModelImpl) { bind<MenuViewModel>() }

    single {
        (get() as Retrofit).create(NewsApi::class.java)
    }

    singleOf(::NewsRepositoryImpl) { bind<NewsRepository>() }
    factoryOf(::NewsResponseToArticlesMapper)

    single<Retrofit> {
        Retrofit.Builder()
            // TODO: move to base url 
            .baseUrl("https://newsapi.org/v2/")
            .client(get())
            .addConverterFactory(
                MoshiConverterFactory.create(
                    get()
                ).withNullSerialization().asLenient()
            )
            .build()
    }

    single {
        Moshi.Builder()
            .add(MoshiArrayListJsonAdapter.FACTORY)
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    single {
        OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    factoryOf(::GetArticlesUseCaseImpl) { bind<GetArticlesUseCase>() }
}