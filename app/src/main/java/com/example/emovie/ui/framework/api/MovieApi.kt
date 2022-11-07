package com.example.emovie.ui.framework.api

import com.example.emovie.ui.framework.api.schemas.response.ResponseWrapper
import com.example.emovie.ui.framework.api.schemas.response.movie.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/upcoming")
    suspend fun getUpcomingMovie(
        @Query("api_key") api_key: String,
    ): Response<ResponseWrapper<List<MovieResponse>>>


    @GET("movie/top_rated")
    suspend fun getTopRatedMovie(
        @Query("api_key") api_key: String,
    ): Response<ResponseWrapper<List<MovieResponse>>>
}