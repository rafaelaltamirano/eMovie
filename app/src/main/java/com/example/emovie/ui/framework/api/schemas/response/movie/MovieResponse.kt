package com.example.emovie.ui.framework.api.schemas.response.movie

import com.example.domain.model.Movie
import com.example.emovie.ui.framework.api.schemas.response.Response

data class MovieResponse(
    val id: Long,
    val backdrop_path: String?,
    val original_title: String?,
    val vote_average: Float?
) : Response<Movie> {
    override fun toEntity() = Movie(
        id = id ,
        poster = backdrop_path ?: "",
        name = original_title ?: "",
        rating = vote_average ?: 1f
    )
}