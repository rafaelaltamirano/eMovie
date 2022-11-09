package com.example.data.datasource.repository

import com.example.domain.model.Movie

class TopRatedMovieRepository(
    private val remote: MoviesRemoteSource,
    private val local: TopRatedMovieLocalSource
) : LocalSource<List<Movie>> {

    var topRatedMovies: List<Movie> = emptyList()
        private set

    suspend fun requestTopRatedMovies() = remote.requestTopRatedMovies().also {
        save(it)
    }

    override suspend fun save(t: List<Movie>) {
        this.topRatedMovies = t
        local.save(t)
    }

    override suspend fun load(): List<Movie> = (local.load() ?: emptyList()).also {
        this.topRatedMovies = it
    }

    override suspend fun clear() = local.clear().also { this.topRatedMovies = emptyList() }

}

interface TopRatedMovieLocalSource : LocalSource<List<Movie>>
