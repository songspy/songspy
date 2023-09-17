package com.songspy.quiz.core.controller.v1.quiz.response

import com.songspy.quiz.core.domains.quiz.QuizTrack

data class QuizTrackResponseDto(
    val tracks: List<TrackResponseDto>
) {
    data class TrackResponseDto(
        val trackId: String,
        val title: String,
        val artistName: String,
        val image: String,
        val previewUrl: String
    ) {
        constructor(quizTracks: QuizTrack) : this(
            trackId = quizTracks.trackId,
            title = quizTracks.title,
            artistName = quizTracks.artistName,
            image = quizTracks.image,
            previewUrl = quizTracks.previewUrl
        )
    }
}
