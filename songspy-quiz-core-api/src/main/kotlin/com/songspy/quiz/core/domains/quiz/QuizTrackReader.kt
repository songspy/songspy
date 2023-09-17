package com.songspy.quiz.core.domains.quiz

import com.songspy.storage.db.core.quiz.QuizTrackEntity
import com.songspy.storage.db.core.quiz.QuizTrackRepository
import org.springframework.stereotype.Component

@Component
class QuizTrackReader(
    private val repository: QuizTrackRepository
) {
    fun readByQuizId(quizId: Long): List<QuizTrackEntity> {
        return repository.findAllByQuizId(quizId)
    }
}
