package com.breakingnews.data.util

import retrofit2.HttpException

suspend fun <T> safeApiCall(call: suspend () -> DataResult<T>): DataResult<T> =
    try {
        call()
    } catch (ex: Exception) {
        when (ex) {
            is HttpException -> DataResult.Error(
                ex.code(),
                ex.message(),
                try {
                    ex.response()?.errorBody()?.string().toString()
                } catch (e: Exception) {
                    ""
                }
            )
            else -> DataResult.Failure(ex)
        }
    }