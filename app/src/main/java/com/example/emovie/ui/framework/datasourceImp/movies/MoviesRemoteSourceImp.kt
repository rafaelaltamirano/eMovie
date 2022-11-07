package com.example.emovie.ui.framework.datasourceImp.movies

import com.example.data.datasource.repository.MoviesRemoteSource
import com.example.domain.model.Movie
import com.example.emovie.ui.framework.api.MovieApi
import com.example.mobicomposeapp.utils.AppConstants.API_KEY
import javax.inject.Inject

class MoviesRemoteSourceImp @Inject constructor(
    private val api: MovieApi
) : MoviesRemoteSource {

    override suspend fun requestTopRatedMovies(): List<Movie> {
        val res = api.getTopRatedMovie(api_key = API_KEY)
        return res.body()!!.results.map { it.toEntity() }}



    override suspend fun requestMoviesByFilters(): List<Movie> {
        TODO("Not yet implemented")
    }

}