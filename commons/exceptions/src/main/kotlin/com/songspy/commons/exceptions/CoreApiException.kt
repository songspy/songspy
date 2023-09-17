package com.songspy.commons.exceptions

class CoreApiException(
    errorType: ErrorType,
) : RuntimeException(errorType.message)