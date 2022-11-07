package com.example.emovie.ui.screen.home

import com.example.domain.model.Movie
import com.example.emovie.ui.screen.home.MovieFilterTypes.FROM_1993
import com.example.emovie.ui.screen.home.MovieFilterTypes.SPANISH


enum class MovieFilterTypes(val url: String) {
    SPANISH("top_rated"),
    FROM_1993("popular"),
}

data class HomeState(
    val category: Map<MovieFilterTypes, String> = mapOf(
        SPANISH to "En español",
        FROM_1993 to "Lanzadas en 1993"),
    val loading: Boolean = false,
    val upcomingMovies: List<Movie> = emptyList(),
    val topRatedMovies: List<Movie> = emptyList()
)