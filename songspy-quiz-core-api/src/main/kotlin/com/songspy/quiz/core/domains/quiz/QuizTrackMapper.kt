package com.songspy.quiz.core.domains.quiz

import com.songspy.storage.db.core.quiz.QuizTrackEntity
import org.springframework.stereotype.Component

@Component
class QuizTrackMapper {
    fun map(entity: QuizTrackEntity): QuizTrack {
        return QuizTrack(
            trackId = entity.trackId,
            title = entity.title,
            artistName = entity.artistName,
            image = entity.image,
            previewUrl = entity.previewUrl
        )
    }
}
