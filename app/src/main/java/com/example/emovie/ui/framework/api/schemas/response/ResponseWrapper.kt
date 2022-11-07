package com.example.emovie.ui.framework.api.schemas.response

data class ResponseWrapper<T>(
    val total_count: Int,
    val results: T
)

