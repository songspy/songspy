package com.songspy.quiz.core.domains.playlist

import com.songspy.quiz.core.domains.search.SpotifyCursor

data class PlaylistTrackResult(
    val cursor: SpotifyCursor?,
    val total: Int,
    val tracks: List<TrackResult>
) {
    data class TrackResult(
        val id: String,
        val title: String,
        val artistName: String,
        val image: String,
        val explicit: Boolean,
        val previewUrl: String?
    )
}
