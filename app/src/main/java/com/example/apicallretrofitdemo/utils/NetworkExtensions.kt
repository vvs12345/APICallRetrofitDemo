//package com.example.apicallretrofitdemo.utils
//
//import java.io.IOException
//
//private const val SUCCESS = "1"
//private const val RE_LOGIN = "-3"
//
//
//
//suspend fun <T> executeCoroutine(apiCall: suspend () -> T): NetworkResponseState<T> {
//    return try {
//        val response = apiCall.invoke()
//        when (response.toString()) {
//            SUCCESS -> NetworkResponseState.Success(response, response.toString())
//            RE_LOGIN -> NetworkResponseState.TokenAuthFailed("response.description")
//            else -> NetworkResponseState.OtherSuccess(response.hashCode(), "response.description", response)
//        }
//    } catch (e: Exception) {
//        e.printStackTrace()
//        when (e) {
//            is retrofit2.HttpException -> {
//                NetworkResponseState.Error(e.code(), "ERROR_NO_NETWORK")
//            }
//            is IOException -> {
//                NetworkResponseState.Error(-2, "ERROR_NO_NETWORK")
//            }
//            else -> {
//                NetworkResponseState.Error(-3, "ERROR_NO_NETWORK")
//            }
//        }
//    }
//}