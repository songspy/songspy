package com.songspy.core.batch.spotify.token

data class TokenBucket(
    val id: Long,
    val accessToken: String,
    val refreshToken: String,
    val userId: Long
)
