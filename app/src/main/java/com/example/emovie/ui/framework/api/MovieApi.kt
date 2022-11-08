package com.example.emovie.ui.framework.api

import com.example.domain.model.MovieDetails
import com.example.emovie.ui.framework.api.schemas.response.ResponseWrapper
import com.example.emovie.ui.framework.api.schemas.response.movie.MovieDetailsResponse
import com.example.emovie.ui.framework.api.schemas.response.movie.MovieResponse
import com.example.emovie.ui.framework.api.schemas.response.movie.VideoDetailsResponse
import com.example.emovie.utils.AppConstants.MOVIE_ID
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface MovieApi {

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("api_key") api_key: String,
    ): Response<ResponseWrapper<List<MovieResponse>>>


    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("language") language: String,
        @Query("api_key") api_key: String,
    ): Response<ResponseWrapper<List<MovieResponse>>>

    @GET("movie/{id}")
    suspend fun getMovieDetails(
        @Path("id") id: String,
        @Query("api_key") api_key: String
    ): Response<MovieDetailsResponse>

    @GET("movie/{id}/videos")
    suspend fun getVideoDetails(
        @Path("id") id: String,
        @Query("api_key") api_key: String,
    ): Response<VideoDetailsResponse>
}