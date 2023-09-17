package com.songspy.commons.api.response

import com.songspy.commons.exceptions.ErrorType

data class CommonApiResponse<T> (
    val result: ResultType,
    val data: T? = null,
    val error: ErrorResponse? = null
) {
    companion object {
        fun success() = CommonApiResponse(ResultType.SUCCESS, null, null)

        fun <T> success(data: T) = CommonApiResponse(ResultType.SUCCESS, data, null)

        fun error(errorType: ErrorType) = CommonApiResponse(ResultType.ERROR, null, ErrorResponse(errorType))
    }
}
