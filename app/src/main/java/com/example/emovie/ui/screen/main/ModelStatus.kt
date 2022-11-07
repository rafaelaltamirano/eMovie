package com.example.emovie.ui.screen.main

enum class Status {
    NETWORK_ERROR,
    ERROR,
    SUCCESS,
    EXPIRED_SESSION,
    FINISH,
    INTERNET_CONNECTION_ERROR,
}

data class ModelStatus(
    val status: Status,
    val message: String? = null
)

data class ErrorStatus(
    val showError: Boolean = false,
    val showGenericError: Boolean = false,
)
