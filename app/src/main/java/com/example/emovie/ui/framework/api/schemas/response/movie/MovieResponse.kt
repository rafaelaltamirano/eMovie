package com.example.emovie.ui.framework.api.schemas.response.movie

import com.example.domain.model.Movie
import com.example.emovie.ui.framework.api.schemas.response.Response

data class MovieResponse(
    val id: Int,
    val backdrop_path: String,
    val original_name: String,
    val vote_average: Float
) : Response<Movie> {
    override fun toEntity() = Movie(
        id = 1,
        poster = backdrop_path,
        name = original_name,
        rating = vote_average
    )
}