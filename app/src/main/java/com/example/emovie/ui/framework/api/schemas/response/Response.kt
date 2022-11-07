package com.example.emovie.ui.framework.api.schemas.response

interface Response<T> {

    fun toEntity(): T

}