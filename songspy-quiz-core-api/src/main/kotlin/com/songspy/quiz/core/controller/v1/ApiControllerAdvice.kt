package com.songspy.quiz.core.controller.v1

import com.songspy.commons.api.response.CommonApiResponse
import com.songspy.commons.exceptions.CoreApiException
import com.songspy.commons.exceptions.ErrorType
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ApiControllerAdvice {
    private val logger = LoggerFactory.getLogger(javaClass)

    @ExceptionHandler(CoreApiException::class)
    fun handleCoreApiException(e: CoreApiException): ResponseEntity<CommonApiResponse<Nothing>> {
        logger.info("[CoreApiException]", e)
        return ResponseEntity(CommonApiResponse.error(e.errorType), e.errorType.statusCode)
    }

    @ExceptionHandler(RuntimeException::class)
    fun handleRuntimeException(e: RuntimeException): ResponseEntity<CommonApiResponse<Nothing>> {
        logger.info("[RuntimeException]", e)
        return ResponseEntity(CommonApiResponse.error(ErrorType.COMMON_ERROR), HttpStatus.INTERNAL_SERVER_ERROR)
    }
}
