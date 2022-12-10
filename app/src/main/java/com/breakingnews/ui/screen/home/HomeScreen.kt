package com.breakingnews.ui.screen.home

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.breakingnews.R
import com.breakingnews.domain.model.Article
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(navController: NavController) {
    val viewModel = koinViewModel<HomeViewModel>()
    val context = LocalContext.current
    val articlesData = viewModel.articlesDataFlow.collectAsState()

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        // TODO: add navigation to article details screen after items click 
        items(items = articlesData.value) {
            ArticleItem(article = it, context = context)
        }
    }
}

@Composable
fun ArticleItem(article: Article, context: Context) {
    var bitmap by remember { mutableStateOf<Bitmap?>(null) }

    Glide.with(context).asBitmap()
        .load(article.imageUrl)
        .into(object : CustomTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                bitmap = resource
            }

            override fun onLoadCleared(placeholder: Drawable?) {}
        })

    Row(modifier = Modifier.padding(20.dp)) {
        Column {
            Text(text = article.title, style = typography.h6)
            imageItem(bitmap, context)
            Text(
                text = article.description,
                style = typography.caption,
                modifier = Modifier.padding(top = 5.dp)
            )
        }
    }
}

@Composable
fun imageItem(bitmap: Bitmap?, context: Context) {
    if (bitmap != null)
        Image(
            bitmap = bitmap.asImageBitmap(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 3.dp, start = 5.dp, end = 5.dp),
            contentDescription = ""
        )
    else
        Text(context.getString(R.string.loading_image))
}