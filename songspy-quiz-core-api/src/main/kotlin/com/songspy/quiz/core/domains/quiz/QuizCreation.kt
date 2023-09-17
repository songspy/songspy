package com.songspy.quiz.core.domains.quiz

import com.songspy.commons.enums.QuizCreateType

data class QuizCreation(
    val type: QuizCreateType,
    val playlistId: String,
    val tracks: List<QuizTrackCreation>?
) {
}
