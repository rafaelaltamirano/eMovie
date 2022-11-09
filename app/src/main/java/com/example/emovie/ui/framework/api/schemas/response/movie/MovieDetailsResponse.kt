package com.example.emovie.ui.framework.api.schemas.response.movie

import com.example.domain.model.Genres
import com.example.domain.model.MovieDetails
import com.example.emovie.ui.framework.api.schemas.response.Response

data class MovieDetailsResponse(
    val id: Long,
    val backdrop_path: String?,
    val original_title: String,
    val vote_average: Float,
    val release_date: String,
    val original_language: String,
    val genres: List<Genres>,
    val overview: String
) : Response<MovieDetails> {
    override fun toEntity() = MovieDetails(
        id = id,
        poster = backdrop_path ?: "",
        name = original_title,
        rating = vote_average,
        releaseDate = release_date.subSequence(0,4).toString(),
        originalLanguage = original_language,
        overview = overview,
        genres = genres
    )
}
