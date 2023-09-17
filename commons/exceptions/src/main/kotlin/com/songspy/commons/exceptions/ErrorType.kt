package com.songspy.commons.exceptions

import org.springframework.http.HttpStatus

enum class ErrorType(val statusCode: HttpStatus, val message: String) {
}