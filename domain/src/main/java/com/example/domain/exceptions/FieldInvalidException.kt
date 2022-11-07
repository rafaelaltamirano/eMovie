package com.example.domain.exceptions

import com.example.domain.enums.Fields
import java.lang.Exception

class FieldInvalidException(
    val field: Fields,
    override val message: String,
    val fieldSecond: Fields? = null,
) : Exception(message)