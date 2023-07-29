package com.songspy.clients.spotify

import com.songspy.clients.spotify.response.PlayingTrackResponseDto
import com.songspy.commons.extension.BearerAuth
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(name = "spotify-api", url = "\${spotify-api.url}")
interface SpotifyApi {
    @GetMapping("/v1/me/player/currently-playing")
    fun getCurrentlyPlayingTrack(@RequestHeader("Authorization") auth: BearerAuth): PlayingTrackResponseDto
}
