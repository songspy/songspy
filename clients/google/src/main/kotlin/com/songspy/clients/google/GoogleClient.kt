package com.songspy.clients.google

import com.songspy.clients.google.response.GoogleUserResponseDto
import org.springframework.stereotype.Component

@Component
class GoogleClient(
    private val googleApi: GoogleApi
) {
    fun getUser(token: String): Result<GoogleUserResponseDto> {
        return runCatching {
            googleApi.getUser(
                token = token
            )
        }
    }
}
