package com.example.apicallretrofitdemo.utils

import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

private const val SUCCESS = "200"
private const val RE_LOGIN = "-3"
enum class UIState {
    LOADING, ERROR_SHOW, ERROR_HIDE, EMPTY, SUCCESS, RE_LOGIN
}
//
//sealed class NetworkResponseState<out T> {
//    data class Success<T> (val result : T, val description: String) : NetworkResponseState<T>()
//    data class Error (val message : String?) : NetworkResponseState<Nothing>()
//    object Loading : NetworkResponseState<Nothing>()
//}
//
//
//suspend fun <T> safeApiCall( apiCall: suspend () -> Response<T>): NetworkResponseState<T> {
//    return try {
//        val response = apiCall.invoke()
//        when (response.code().toString()) {
//            SUCCESS -> NetworkResponseState.Success(response.body() as T, response.message())
//            RE_LOGIN -> NetworkResponseState.Error(response.message())
//            else -> NetworkResponseState.Error(response.message())
//        }
//    } catch (e: Exception) {
//        e.printStackTrace()
//        when (e) {
//            is HttpException -> {
//                NetworkResponseState.Error(e.message())
//            }
//            is IOException -> {
//                NetworkResponseState.Error(e.message)
//            }
//            else -> {
//                NetworkResponseState.Error(e.message)
//            }
//        }
//    }
//}



// A helper class to handle states
data class CommentApiState<out T>(val status: Status, val data: T?, val message: String?) {

    companion object {

        // In case of Success,set status as
        // Success and data as the response
        fun <T> success(data: T?): CommentApiState<T> {
            return CommentApiState(Status.SUCCESS, data, null)
        }

        // In case of failure ,set state to Error ,
        // add the error message,set data to null
        fun <T> error(msg: String): CommentApiState<T> {
            return CommentApiState(Status.ERROR, null, msg)
        }

        // When the call is loading set the state
        // as Loading and rest as null
        fun <T> loading(): CommentApiState<T> {
            return CommentApiState(Status.LOADING, null, null)
        }
    }
}

// An enum to store the
// current state of api call
enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}