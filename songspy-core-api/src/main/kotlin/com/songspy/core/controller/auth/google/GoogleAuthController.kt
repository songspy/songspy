package com.songspy.core.controller.auth.google

import com.songspy.commons.api.response.CommonApiResponse
import com.songspy.core.controller.auth.google.request.GoogleAuthRequestDto
import com.songspy.core.controller.auth.google.response.GoogleAuthResponseDto
import com.songspy.core.domains.auth.google.GoogleAuthService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/songspy/google-auth")
class GoogleAuthController(
    private val googleAuthService: GoogleAuthService
) {
    @PostMapping
    fun auth(
        @RequestBody body: GoogleAuthRequestDto
    ): CommonApiResponse<GoogleAuthResponseDto> {
        val userWithToken = googleAuthService.auth(body.accessToken)
        return CommonApiResponse.success(GoogleAuthResponseDto(userWithToken))
    }
}
