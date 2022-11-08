package com.example.emovie.ui.framework.datasourceImp.movies

import com.example.data.datasource.repository.MovieDetailsDao
import com.example.domain.model.MovieDetails
import com.example.domain.model.VideoDetails
import com.example.emovie.ui.framework.api.MovieApi
import com.example.emovie.utils.AppConstants
import javax.inject.Inject

class MovieDetailsDaoImp @Inject constructor(
    private val api: MovieApi
): MovieDetailsDao{
    override suspend fun requestVideoDetails(): VideoDetails {
        val res = api.getVideoDetails(api_key = AppConstants.API_KEY, id = "674324")

        return res.body()!!.toEntity()
    }

    override suspend fun requestMovieDetails(id: Long): MovieDetails {
        val res = api.getMovieDetails(api_key = AppConstants.API_KEY, id = id.toString())
        return res.body()!!.toEntity()
    }
}