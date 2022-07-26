package com.example.apicallretrofitdemo.utils

import com.example.apicallretrofitdemo.datamodels.ResponseObject
import retrofit2.HttpException
import java.io.IOException

/**
 * <h1>NehaM</h1>
 *
 * @author Neha Mehta (neham@meditab.com) Meditab Software Inc.
 * @since 20/7/18 12:23 PM
 *
 */

private const val ERROR_NO_NETWORK = "Unable to connect to server. Please contact Meditab support."
private const val NETWORK_ERROR_CODE = 503
private const val INTERNAL_SERVER_ERROR_CODE = 500
private const val SUCCESS = "1"
private const val RE_LOGIN = "-3"


suspend fun <T> executeCoroutine(apiCall: suspend () -> ResponseObject<T>): CommentApiState<T> {
    return try {
        val response = apiCall.invoke()
        when (response.code) {
            SUCCESS -> CommentApiState.Success(response.data, response.description)
            RE_LOGIN -> CommentApiState.TokenAuthFailed(response.description)
            else -> CommentApiState.OtherSuccess(response.code.toInt(), response.description, response.data)
        }
    } catch (e: Exception) {
        e.printStackTrace()
        when (e) {
            is HttpException -> {
                CommentApiState.Error(e.code(), ERROR_NO_NETWORK)
            }
            is IOException -> {
                CommentApiState.Error(NETWORK_ERROR_CODE, ERROR_NO_NETWORK)
            }
            else -> {
                CommentApiState.Error(INTERNAL_SERVER_ERROR_CODE, ERROR_NO_NETWORK)
            }
        }
    }
}