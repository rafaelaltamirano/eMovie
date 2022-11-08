package com.example.data.datasource.repository

import com.example.domain.model.Movie
import com.example.domain.model.MovieDetails
import com.example.domain.model.VideoDetails

interface MoviesRemoteSource {
    suspend fun requestUpcomingMovies(): List<Movie>
    suspend fun requestTopRatedMovies(): List<Movie>
}