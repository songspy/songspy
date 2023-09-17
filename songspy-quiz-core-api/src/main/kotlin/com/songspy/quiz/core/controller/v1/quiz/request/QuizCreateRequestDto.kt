package com.songspy.quiz.core.controller.v1.quiz.request

import com.songspy.commons.enums.QuizCreateType
import com.songspy.commons.exceptions.CoreApiException
import com.songspy.commons.exceptions.ErrorType
import com.songspy.quiz.core.domains.quiz.QuizCreation
import com.songspy.quiz.core.domains.quiz.QuizTrackCreation

data class QuizCreateRequestDto(
    val type: QuizCreateType,
    val playlistId: String,
    val tracks: List<QuizTrackRequestDto>?
) {
    init {
        validate()
    }

    private fun validate() {
        if (type == QuizCreateType.CUSTOM && tracks?.size == 0) {
            throw CoreApiException(ErrorType.INVALID_REQUEST, "퀴즈를 만들기 위해서는 플레이리스트 곡 정보가 필요합니다.")
        }
    }

    fun toDomain(): QuizCreation {
        return QuizCreation(
            type = type,
            playlistId = playlistId,
            tracks = tracks?.map {
                QuizTrackCreation(
                    id = it.id,
                    title = it.title,
                    artistName = it.artistName,
                    image = it.image,
                    previewUrl = it.previewUrl
                )
            }
        )
    }

    data class QuizTrackRequestDto(
        val id: String,
        val title: String,
        val artistName: String,
        val image: String,
        val previewUrl: String
    )
}
