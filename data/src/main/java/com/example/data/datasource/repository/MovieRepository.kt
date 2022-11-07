package com.example.data.datasource.repository

import com.example.domain.model.Movie

class MovieRepository(
    private val remote: MoviesRemoteSource,
    private val local: MoviesLocalSource
) : LocalSource<List<Movie>> {

    var movies: List<Movie> = emptyList()
        private set

    suspend fun requestTopRatedMovies(idPart: String) = remote.requestTopRatedMovies().also {
        save(it)
    }

    suspend fun requestMoviesByFilters(
    ) = remote.requestMoviesByFilters()

    override suspend fun save(t: List<Movie>) {
        this.movies = t
        local.save(t)
    }

    override suspend fun load(): List<Movie> = (local.load() ?: emptyList()).also {
        this.movies = it
    }

    override suspend fun clear() = local.clear().also { this.movies = emptyList() }

}

interface MoviesRemoteSource {

    suspend fun requestTopRatedMovies(): List<Movie>

    suspend fun requestMoviesByFilters(): List<Movie>

}

interface MoviesLocalSource : LocalSource<List<Movie>>