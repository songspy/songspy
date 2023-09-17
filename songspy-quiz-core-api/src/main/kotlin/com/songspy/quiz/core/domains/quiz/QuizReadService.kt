package com.songspy.quiz.core.domains.quiz

import org.springframework.stereotype.Service

@Service
class QuizReadService(
    private val quizTrackReader: QuizTrackReader,
    private val mapper: QuizTrackMapper
) {
    fun readByQuizId(quizId: Long): List<QuizTrack> {
        return quizTrackReader.readByQuizId(quizId)
            .map { mapper.map(it) }
    }
}
