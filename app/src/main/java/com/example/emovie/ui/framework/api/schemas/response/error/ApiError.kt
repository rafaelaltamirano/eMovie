package com.example.emovie.ui.framework.api.schemas.response.error

import com.example.emovie.ui.framework.api.schemas.response.Response
import java.util.*

data class ApiError(
    val success: Boolean,
    val status_message: String,
    val status_code: Int,
)
