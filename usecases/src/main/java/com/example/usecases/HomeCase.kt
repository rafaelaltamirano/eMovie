package com.example.usecases

import com.example.data.datasource.repository.MovieDetailsDao
import com.example.data.datasource.repository.TopRatedMovieRepository
import com.example.data.datasource.repository.UpComingMovieRepository
import com.example.domain.model.Movie
import com.example.domain.model.MovieDetails
import com.example.domain.model.VideoDetails


class HomeCase(
    private val upComingMovieRepo: UpComingMovieRepository,
    private val topRatedMovieRepo: TopRatedMovieRepository,
    private val movieDetailsDao: MovieDetailsDao
) {
    suspend fun requestUpcomingMovies(): List<Movie> = upComingMovieRepo.requestUpcomingMovies()
    suspend fun requestTopRatedMovies(): List<Movie> = topRatedMovieRepo.requestTopRatedMovies()
    suspend fun requestMovieDetails(id: Long): MovieDetails = movieDetailsDao.requestMovieDetails(id)
    suspend fun requestVideoDetails(): VideoDetails = movieDetailsDao.requestVideoDetails()


    fun loadTopRatedMovies() = topRatedMovieRepo.topRatedMovies
    fun loadUpComingMovies() = upComingMovieRepo.upComingMovies
}

