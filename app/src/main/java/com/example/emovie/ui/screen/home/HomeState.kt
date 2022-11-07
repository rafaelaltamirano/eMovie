package com.example.emovie.ui.screen.home

import com.example.domain.model.Movie
import com.example.emovie.ui.screen.home.MovieFilterTypes.FROM_1993
import com.example.emovie.ui.screen.home.MovieFilterTypes.SPANISH


enum class MovieFilterTypes(val url: String) {
    SPANISH("es"),
    FROM_1993("1993"),
}

data class HomeState(
    val category: Map<MovieFilterTypes, String> = mapOf(
        SPANISH to "En español",
        FROM_1993 to "Lanzadas en 1993"),
    val loadingUpComing: Boolean = false,
    val loadingTopRated: Boolean = false,
    val loadingSwipe: Boolean = false,
    val upcomingMovies: List<Movie> = emptyList(),
    val topRatedMovies: List<Movie> = emptyList(),
    val topRatedByFilterMovies: List<Movie> = emptyList(),
    var selectedFilter: String = ""
)