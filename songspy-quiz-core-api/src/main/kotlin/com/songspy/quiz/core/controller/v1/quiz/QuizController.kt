package com.songspy.quiz.core.controller.v1.quiz

import com.songspy.commons.api.response.CommonApiResponse
import com.songspy.quiz.core.controller.v1.quiz.request.QuizCreateRequestDto
import com.songspy.quiz.core.controller.v1.quiz.response.QuizCreateResponseDto
import com.songspy.quiz.core.domains.quiz.QuizCreateService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/songspy/quiz")
class QuizController(
    private val quizCreateService: QuizCreateService
) {
    @PostMapping
    fun create(
        @RequestBody body: QuizCreateRequestDto
    ): CommonApiResponse<QuizCreateResponseDto> {
        val quizId = quizCreateService.create(body.toDomain())
        return CommonApiResponse.success(QuizCreateResponseDto(quizId))
    }
}
