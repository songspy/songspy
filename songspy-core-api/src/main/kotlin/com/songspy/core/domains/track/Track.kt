package com.songspy.core.domains.track

import java.time.LocalDateTime

data class Track(
    val id: Long,
    val createdAt: LocalDateTime,
    val userId: Long,
    val title: String,
    val artistName: String,
    val originalUrl: String,
    val previewUrl: String,
    val albumImageUrl: String
)
