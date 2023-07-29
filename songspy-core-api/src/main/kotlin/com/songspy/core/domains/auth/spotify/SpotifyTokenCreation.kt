package com.songspy.core.domains.auth.spotify

data class SpotifyTokenCreation(
    val userId: Long,
    val accessToken: String,
    val refreshToken: String
)
