package com.example.domain.model

data class MovieDetails(
    var id: Long  ,
    val poster: String,
    val name: String,
    val rating: Float,
    val releaseDate: String,
    val originalLanguage: String,
    val genres: List<Genres>,
    val overview: String
)

data class Genres(
    val name:String
)
