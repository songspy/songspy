package com.songspy.commons.exceptions

import org.springframework.http.HttpStatus

enum class ErrorType(val statusCode: HttpStatus, val message: String) {
    INVALID_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청입니다.")
}