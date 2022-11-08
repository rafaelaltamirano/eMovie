package com.example.emovie.ui.framework.datasourceImp.movies

import com.example.data.datasource.repository.MovieDetailsDao
import com.example.domain.model.MovieDetails
import com.example.domain.model.VideoDetails
import com.example.emovie.ui.framework.api.ApiTools.validateResponseOrFail
import com.example.emovie.ui.framework.api.MovieApi
import com.example.emovie.utils.AppConstants
import javax.inject.Inject

class MovieDetailsDaoImp @Inject constructor(
    private val api: MovieApi
): MovieDetailsDao{
    override suspend fun requestVideoDetails(id: Long): List<VideoDetails> {
        val res = api.getVideoDetails(api_key = AppConstants.API_KEY, id = id.toString())
        validateResponseOrFail(res)
        return res.body()!!.results.map { item ->
            item.key.let { item.toEntity()}
        }
    }

    override suspend fun requestMovieDetails(id: Long): MovieDetails {
        val res = api.getMovieDetails(api_key = AppConstants.API_KEY, id = id.toString())
        validateResponseOrFail(res)
        return res.body()!!.toEntity()
    }
}