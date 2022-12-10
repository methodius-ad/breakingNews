package com.breakingnews.data.util

sealed class DataResult<out T> {
    data class Success<out T>(val data: T) : DataResult<T>()
    data class Failure(val exception: Throwable) : DataResult<Nothing>()
    data class Error(val code: Int, val message: String, val errorJson: String? = null) : DataResult<Nothing>()
    data class Loading(val isShown: Boolean) : DataResult<Nothing>()
}