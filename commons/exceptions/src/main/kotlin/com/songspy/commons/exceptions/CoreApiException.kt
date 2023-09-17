package com.songspy.commons.exceptions

class CoreApiException(
    val errorType: ErrorType,
    message: String = errorType.message
) : RuntimeException(message)
