package com.songspy.quiz.core.domains.quiz

data class QuizTrack(
    val trackId: String,
    val title: String,
    val artistName: String,
    val image: String,
    val previewUrl: String
)
