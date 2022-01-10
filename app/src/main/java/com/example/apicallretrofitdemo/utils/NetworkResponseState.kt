package com.example.apicallretrofitdemo.utils

import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

private const val SUCCESS = "200"
private const val RE_LOGIN = "-3"
enum class UIState {
    LOADING, ERROR_SHOW, ERROR_HIDE, EMPTY, SUCCESS, RE_LOGIN
}

sealed class NetworkResponseState<out T> {
    data class Success<T> (val result : T, val description: String) : NetworkResponseState<T>()
    data class Error (val message : String?) : NetworkResponseState<Nothing>()
    object Loading : NetworkResponseState<Nothing>()
}


suspend fun <T> safeApiCall( apiCall: suspend () -> Response<T>): NetworkResponseState<T> {
    return try {
        val response = apiCall.invoke()
        when (response.code().toString()) {
            SUCCESS -> NetworkResponseState.Success(response.body() as T, response.message())
            RE_LOGIN -> NetworkResponseState.Error(response.message())
            else -> NetworkResponseState.Error(response.message())
        }
    } catch (e: Exception) {
        e.printStackTrace()
        when (e) {
            is HttpException -> {
                NetworkResponseState.Error(e.message())
            }
            is IOException -> {
                NetworkResponseState.Error(e.message)
            }
            else -> {
                NetworkResponseState.Error(e.message)
            }
        }
    }
}