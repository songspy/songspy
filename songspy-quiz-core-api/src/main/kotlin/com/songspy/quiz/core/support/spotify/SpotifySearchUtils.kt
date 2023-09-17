package com.songspy.quiz.core.support.spotify

import com.songspy.clients.spotify.response.ImageResponseDto

object SpotifySearchUtils {
    fun getImage(images: List<ImageResponseDto>): String {
        return if (images.isNotEmpty()) {
            images[0].url
        } else {
            "default image"
        }
    }
}