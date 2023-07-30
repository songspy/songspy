package com.songspy.clients.google

import com.songspy.clients.google.response.GoogleUserResponseDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "google-api", url = "\${google-api.url}")
interface GoogleApi {
    @GetMapping("/oauth2/v1/userinfo")
    fun getUser(
        @RequestParam("access_token") token: String
    ): GoogleUserResponseDto
}
