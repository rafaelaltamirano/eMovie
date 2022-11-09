package com.example.emovie.ui.framework.api

import com.example.domain.exceptions.HttpException
import com.example.emovie.ui.framework.api.schemas.response.error.ApiError
import com.google.gson.Gson
import retrofit2.Response
import java.lang.Exception

object ApiTools {
    //si la respuesta no es buena mapea el json de error
    fun <T> validateResponseOrFail(res: Response<T>) {
        if (res.isSuccessful) return
        val error = res.errorBody()!!.string()
        val code = res.code()
        val errorMessage = try {
            Gson().fromJson(error, ApiError::class.java).status_message
        } catch (e: Exception) {
            res.message()
        }
        throw HttpException(code, errorMessage)
    }
}
