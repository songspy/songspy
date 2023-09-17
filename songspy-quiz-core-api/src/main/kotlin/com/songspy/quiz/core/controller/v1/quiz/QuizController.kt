package com.songspy.quiz.core.controller.v1.quiz

import com.songspy.commons.api.response.CommonApiResponse
import com.songspy.quiz.core.controller.v1.quiz.request.QuizCreateRequestDto
import com.songspy.quiz.core.controller.v1.quiz.response.QuizCreateResponseDto
import com.songspy.quiz.core.controller.v1.quiz.response.QuizTrackResponseDto
import com.songspy.quiz.core.domains.quiz.QuizCreateService
import com.songspy.quiz.core.domains.quiz.QuizReadService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/songspy/quiz")
class QuizController(
    private val quizCreateService: QuizCreateService,
    private val quizReadService: QuizReadService
) {
    @PostMapping
    fun create(
        @RequestBody body: QuizCreateRequestDto
    ): CommonApiResponse<QuizCreateResponseDto> {
        val quizId = quizCreateService.create(body.toDomain())
        return CommonApiResponse.success(QuizCreateResponseDto(quizId))
    }

    @GetMapping("/{id}")
    fun read(
        @PathVariable id: Long
    ): CommonApiResponse<QuizTrackResponseDto> {
        val tracks = quizReadService.readByQuizId(id)
        return CommonApiResponse.success(
            QuizTrackResponseDto(
                tracks = tracks.map { QuizTrackResponseDto.TrackResponseDto(it) }
            )
        )
    }
}
