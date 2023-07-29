package com.songspy.core.domains.auth

import java.time.LocalDateTime

typealias Token = String

data class TokenBucket(
    val accessToken: Token,
    val refreshToken: Token,
    val expiredAt: LocalDateTime
)
