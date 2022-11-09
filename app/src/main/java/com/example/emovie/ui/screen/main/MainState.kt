package com.example.emovie.ui.screen.main


data class MainState(
    val scope: String?= null,
    val showSplash: Boolean = true,
    val errorStatus: ModelStatus? = null,
    val networkErrorStatus: ModelStatus? = null,
    val internetConnectionError: ModelStatus? = null,
    )