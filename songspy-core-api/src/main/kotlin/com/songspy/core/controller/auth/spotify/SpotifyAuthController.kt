package com.songspy.core.controller.auth.spotify

import com.songspy.commons.api.response.CommonApiResponse
import com.songspy.core.domains.auth.spotify.SpotifyAuthService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/spotify-auth")
class SpotifyAuthController(
    private val spotifyAuthService: SpotifyAuthService
) {
    @PostMapping
    fun auth(
        @RequestParam code: String
    ): CommonApiResponse<Boolean> {
        // TODO userId resolve
        spotifyAuthService.auth(code, 0L)
        return CommonApiResponse.success(true)
    }
}
