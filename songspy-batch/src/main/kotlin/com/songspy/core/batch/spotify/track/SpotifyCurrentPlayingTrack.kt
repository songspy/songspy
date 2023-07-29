package com.songspy.core.batch.spotify.track

data class SpotifyCurrentPlayingTrack(
    val title: String,
    val artistName: String,
    val originalUrl: String,
    val previewUrl: String
)
