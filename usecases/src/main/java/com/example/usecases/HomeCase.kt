package com.example.usecases

import com.example.data.datasource.repository.TopRatedMovieRepository
import com.example.data.datasource.repository.UpComingMovieRepository
import com.example.domain.model.Movie


class HomeCase(
    private val upComingMovieRepo: UpComingMovieRepository,
    private val topRatedMovieRepo: TopRatedMovieRepository
) {
    suspend fun requestUpcomingMovies(): List<Movie> = upComingMovieRepo.requestUpcomingMovies()
    suspend fun requestTopRatedMovies(): List<Movie> = topRatedMovieRepo.requestTopRatedMovies()

    fun loadTopRatedMovies() = topRatedMovieRepo.topRatedMovies
    fun loadUpComingMovies() = upComingMovieRepo.upComingMovies
}

