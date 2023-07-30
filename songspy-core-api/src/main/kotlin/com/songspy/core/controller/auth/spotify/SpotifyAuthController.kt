package com.songspy.core.controller.auth.spotify

import com.songspy.commons.api.response.CommonApiResponse
import com.songspy.core.domains.auth.spotify.SpotifyAuthService
import com.songspy.core.support.Constants
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/songspy/spotify-auth")
class SpotifyAuthController(
    private val spotifyAuthService: SpotifyAuthService
) {
    @PostMapping
    fun auth(
        @RequestParam code: String,
        @RequestAttribute(Constants.USER_ID) userId: Long
    ): CommonApiResponse<Boolean> {
        spotifyAuthService.auth(code, userId)
        return CommonApiResponse.success(true)
    }
}
