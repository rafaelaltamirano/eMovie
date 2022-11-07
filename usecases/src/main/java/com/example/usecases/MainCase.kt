package com.example.usecases

import com.example.data.datasource.repository.TopRatedMovieRepository
import com.example.data.datasource.repository.UpComingMovieRepository

class MainCase(private val upComingMovieRepo: UpComingMovieRepository,
               private val topRatedMovieRepo: TopRatedMovieRepository
) {
    suspend fun logout() {
        upComingMovieRepo.clear()
        topRatedMovieRepo.clear()
    }

    suspend fun loadFromCache() {
        upComingMovieRepo.load()
        topRatedMovieRepo.load()
    }
}