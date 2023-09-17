package com.songspy.quiz.core.domains.quiz

import com.songspy.storage.db.core.quiz.QuizTrackEntity
import com.songspy.storage.db.core.quiz.QuizTrackRepository
import org.springframework.stereotype.Component

@Component
class QuizTrackCreator(
    private val repository: QuizTrackRepository,
    private val mapper: QuizTrackEntityMapper
) {
    fun createAll(quizId: Long, playlistId: String, trackCreation: List<QuizTrackCreation>): List<QuizTrackEntity> {
        return trackCreation.map {
            mapper.map(quizId, playlistId, it)
        }.run { repository.saveAll(this) }
    }
}