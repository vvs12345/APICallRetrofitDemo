package com.example.apicallretrofitdemo.utils

// A helper class to handle states

sealed class CommentApiState<out T> {

    data class Success<out T>(val data: T?, val description: String) : CommentApiState<T>()

    data class Error<out T>(val code: Int, val description: String) : CommentApiState<T>()

    data class OtherSuccess<out T>(val code: Int, val description: String, val data: T?) : CommentApiState<T>()

    data class TokenAuthFailed<out T>(val description: String) : CommentApiState<T>()

}

// An enum to store the
// current state of api call
enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}