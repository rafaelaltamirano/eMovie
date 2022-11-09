package com.example.emovie.ui.framework.api.schemas.response.movie

import com.example.domain.model.Movie
import com.example.domain.model.VideoDetails
import com.example.emovie.ui.framework.api.schemas.response.Response

data class VideoDetailsResponse(
    val key: String
): Response<VideoDetails> {
    override fun toEntity() = VideoDetails(
        key = key,
    )
}
