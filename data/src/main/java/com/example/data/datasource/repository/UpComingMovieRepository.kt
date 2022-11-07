package com.example.data.datasource.repository

import com.example.domain.model.Movie

class UpComingMovieRepository(
    private val remote: MoviesRemoteSource,
    private val local: UpComingMoviesLocalSource
) : LocalSource<List<Movie>> {

    var upComingMovies: List<Movie> = emptyList()
        private set

    suspend fun requestUpcomingMovies() = remote.requestUpcomingMovies().also {
        save(it)
    }
    override suspend fun save(t: List<Movie>) {
        this.upComingMovies = t
        local.save(t)
    }

    override suspend fun load(): List<Movie> = (local.load() ?: emptyList()).also {
        this.upComingMovies = it
    }

    override suspend fun clear() = local.clear().also { this.upComingMovies = emptyList() }

}

interface UpComingMoviesLocalSource : LocalSource<List<Movie>>
