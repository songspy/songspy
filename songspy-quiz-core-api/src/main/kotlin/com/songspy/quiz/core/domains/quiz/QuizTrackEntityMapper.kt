package com.songspy.quiz.core.domains.quiz

import com.songspy.storage.db.core.quiz.QuizTrackEntity
import org.springframework.stereotype.Component

@Component
class QuizTrackEntityMapper {
    fun map(quizId: Long, playlistId: String, creation: QuizTrackCreation): QuizTrackEntity {
        return QuizTrackEntity(
            quizId = quizId,
            playlistId = playlistId,
            trackId = creation.id,
            title = creation.title,
            artistName = creation.artistName,
            image = creation.image,
            previewUrl = creation.previewUrl
        )
    }
}