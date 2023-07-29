package com.songspy.clients.spotify.response

import com.fasterxml.jackson.annotation.JsonProperty

data class TokenRefreshResponseDto(
    @JsonProperty("access_token")
    val accessToken: String,
    @JsonProperty("token_type")
    val tokenType: String,
    @JsonProperty("expires_in")
    val expiresIn: Int,
    val scope: String
)
