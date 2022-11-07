package com.example.emovie.ui.router

import com.example.mobicomposeapp.ui.router.Routers


enum class RouterDir (override val route: String) : Routers {
    SPLASH("splash"),
    HOME("home"),
    DETAIL("detail"),
}