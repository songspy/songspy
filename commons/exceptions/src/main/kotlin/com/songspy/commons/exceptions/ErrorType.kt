package com.songspy.commons.exceptions

import org.springframework.http.HttpStatus

enum class ErrorType(val statusCode: HttpStatus, val message: String) {
    INVALID_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),

    COMMON_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "일시적인 처리 오류입니다.")
}
