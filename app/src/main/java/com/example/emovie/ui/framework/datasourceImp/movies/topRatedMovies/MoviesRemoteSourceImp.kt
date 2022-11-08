package com.example.emovie.ui.framework.datasourceImp.movies.topRatedMovies

import com.example.data.datasource.repository.MoviesRemoteSource
import com.example.domain.model.Movie
import com.example.domain.model.MovieDetails
import com.example.domain.model.VideoDetails
import com.example.emovie.ui.framework.api.ApiTools
import com.example.emovie.ui.framework.api.MovieApi
import com.example.emovie.utils.AppConstants.API_KEY
import javax.inject.Inject

class MoviesRemoteSourceImp @Inject constructor(
    private val api: MovieApi
) : MoviesRemoteSource {

    override suspend fun requestUpcomingMovies(): List<Movie> {
        val res = api.getUpcomingMovies(api_key = API_KEY)
        ApiTools.validateResponseOrFail(res)
        return res.body()!!.results.mapNotNull { item ->
            item.backdrop_path?.let { item.toEntity()}
        }

    }

    override suspend fun requestTopRatedMovies(): List<Movie> {
        val res = api.getTopRatedMovies(api_key = API_KEY, language = "es-ES")
        ApiTools.validateResponseOrFail(res)
        return res.body()!!.results.mapNotNull { item ->
            item.backdrop_path?.let { item.toEntity() }
        }
    }


}