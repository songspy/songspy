package com.songspy.quiz.core.domains.quiz

import com.songspy.commons.enums.QuizCreateType
import com.songspy.quiz.core.domains.playlist.SpotifyTrackFetcher
import org.springframework.stereotype.Service

@Service
class QuizCreateService(
    private val quizCreator: QuizCreator,
    private val quizTrackCreator: QuizTrackCreator,
    private val trackFetcher: SpotifyTrackFetcher
) {
    fun create(creation: QuizCreation): Long {
        val quizId = quizCreator.create(creation.playlistId).id
        when (creation.type) {
            QuizCreateType.CUSTOM -> quizTrackCreator.createAll(quizId, creation.playlistId, creation.tracks!!)
            QuizCreateType.RANDOM -> {
                val trackCreations = trackFetcher.fetchByPlaylistIdAndOffset(creation.playlistId, offset = 0).tracks
                    .filter { it.canPlay() }
                    .shuffled()
                    .take(randomQuizTrackSize)
                    .map {
                        QuizTrackCreation(
                            id = it.id,
                            title = it.title,
                            artistName = it.artistName,
                            image = it.image,
                            previewUrl = it.previewUrl!!
                        )
                    }
                quizTrackCreator.createAll(quizId, creation.playlistId, trackCreations)
            }
        }
        return quizId
    }

    companion object {
        private const val randomQuizTrackSize = 10
    }
}
