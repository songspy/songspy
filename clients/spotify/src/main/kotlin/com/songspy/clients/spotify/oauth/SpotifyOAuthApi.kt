package com.songspy.clients.spotify.oauth

import com.songspy.clients.spotify.response.AccessTokenResponse
import com.songspy.commons.extension.BasicAuth
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "spotify-oauth-api", url = "\${spotify-api.oauth.url}")
interface SpotifyOAuthApi {
    @PostMapping(
        value = ["/api/token"],
        consumes = [MediaType.APPLICATION_FORM_URLENCODED_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getAccessToken(
        @RequestHeader("Authorization") auth: BasicAuth,
        @RequestParam("grant_type") grantType: String = "authorization_code",
        @RequestParam("code") code: String,
        @RequestParam("redirect_uri") redirectUrl: String
    ): AccessTokenResponse
}
