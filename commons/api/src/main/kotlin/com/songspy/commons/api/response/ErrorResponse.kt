package com.songspy.commons.api.response

import com.songspy.commons.exceptions.ErrorType

data class ErrorResponse(
    val code: String,
    val message: String
) {
    constructor(errorType: ErrorType) : this(
        code = errorType.name,
        message = errorType.message
    )
}
