package com.songspy.core.domains.auth.google

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class GoogleTokenPayload(
    val sub: String,
    val email: String
)
