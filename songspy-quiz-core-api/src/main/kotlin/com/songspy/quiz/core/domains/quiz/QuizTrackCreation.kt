package com.songspy.quiz.core.domains.quiz

data class QuizTrackCreation(
    val id: String,
    val title: String,
    val artistName: String,
    val image: String,
    val previewUrl: String
)
