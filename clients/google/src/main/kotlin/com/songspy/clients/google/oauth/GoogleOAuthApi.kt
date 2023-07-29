package com.songspy.clients.google.oauth

import com.songspy.clients.google.response.AccessTokenResponseDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "google-oauth-api", url = "\${google-api.oauth.url}")
interface GoogleOAuthApi {
    @PostMapping(
        value = ["/token"],
        consumes = [MediaType.APPLICATION_FORM_URLENCODED_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getAccessToken(
        @RequestParam("client_id") clientId: String,
        @RequestParam("client_secret") clientSecret: String,
        @RequestParam("grant_type") grantType: String = "authorization_code",
        @RequestParam("code") code: String,
        @RequestParam("redirect_uri") redirectUrl: String
    ): AccessTokenResponseDto
}
