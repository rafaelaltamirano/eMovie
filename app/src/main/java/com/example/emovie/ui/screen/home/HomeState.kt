package com.example.emovie.ui.screen.home


enum class TvShowTypes(val url: String) {
    TOP_RATED("top_rated"),
    POPULAR("popular"),
    ON_TV("on_the_air"),
    AIRING_TODAY("airing_today")
}

data class HomeState(
    val loading: Boolean = false,
    )
