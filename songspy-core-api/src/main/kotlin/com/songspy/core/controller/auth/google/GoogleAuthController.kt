package com.songspy.core.controller.auth.google

import com.songspy.commons.api.response.CommonApiResponse
import com.songspy.core.controller.auth.google.response.AuthResponse
import com.songspy.core.domains.auth.google.GoogleAuthService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/google-auth")
class GoogleAuthController(
    private val googleAuthService: GoogleAuthService
) {
    @GetMapping
    fun auth(
        @RequestParam code: String
    ): CommonApiResponse<AuthResponse> {
        val token = googleAuthService.auth(code)
        return CommonApiResponse.success(AuthResponse(token))
    }
}
