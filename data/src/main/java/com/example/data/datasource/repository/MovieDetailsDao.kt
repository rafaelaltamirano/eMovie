package com.example.data.datasource.repository

import com.example.domain.model.MovieDetails
import com.example.domain.model.VideoDetails

interface MovieDetailsDao {
    suspend fun requestVideoDetails(id: Long): List<VideoDetails>
    suspend fun requestMovieDetails(id: Long): MovieDetails
}