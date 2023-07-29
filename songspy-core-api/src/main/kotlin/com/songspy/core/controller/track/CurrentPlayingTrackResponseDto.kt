package com.songspy.core.controller.track

import com.songspy.core.domains.track.Track
import java.time.LocalDateTime

data class CurrentPlayingTrackResponseDto(
    val id: Long,
    val createdAt: LocalDateTime,
    val title: String,
    val artistName: String,
    val originalUrl: String,
    val previewUrl: String,
    val albumImageUrl: String
) {
    constructor(track: Track) : this(
        id = track.id,
        createdAt = track.createdAt,
        title = track.title,
        artistName = track.artistName,
        originalUrl = track.originalUrl,
        previewUrl = track.previewUrl,
        albumImageUrl = track.albumImageUrl
    )
}
