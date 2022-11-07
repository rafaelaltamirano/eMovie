package com.example.usecases

import com.example.data.datasource.repository.MovieRepository
import com.example.domain.model.Movie
import java.lang.Exception


class HomeCase(
    private val movieRepo: MovieRepository
) {

    suspend fun requestUpcomingMovies(): List<Movie> = movieRepo.requestUpcomingMovies()
    suspend fun requestTopRatedMovies(): List<Movie> = movieRepo.requestTopRatedMovies()


}

