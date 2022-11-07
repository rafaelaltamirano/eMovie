package com.example.data.datasource.repository

import com.example.domain.model.Movie

interface MoviesRemoteSource {
    suspend fun requestUpcomingMovies(): List<Movie>
    suspend fun requestTopRatedMovies(): List<Movie>
}