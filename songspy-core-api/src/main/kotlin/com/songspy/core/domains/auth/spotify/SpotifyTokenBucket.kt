package com.songspy.core.domains.auth.spotify

data class SpotifyTokenBucket(
    val id: Long,
    val accessToken: String,
    val refreshToken: String,
    val userId: Long
)
