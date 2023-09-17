package com.songspy.quiz.core.domains.quiz

import com.songspy.storage.db.core.quiz.QuizEntity
import com.songspy.storage.db.core.quiz.QuizRepository
import org.springframework.stereotype.Component

@Component
class QuizCreator(
    private val repository: QuizRepository
) {
    fun create(playlistId: String): QuizEntity {
        return repository.save(QuizEntity(playlistId))
    }
}