package com.songspy.clients.google.response

import com.fasterxml.jackson.annotation.JsonProperty

data class AccessTokenResponseDto(
    @JsonProperty("access_token")
    val accessToken: String,
    @JsonProperty("expires_int")
    val expiresIn: Int,
    val scope: String,
    @JsonProperty("token_type")
    val tokenType: String,
    @JsonProperty("id_token")
    val id: String
)
