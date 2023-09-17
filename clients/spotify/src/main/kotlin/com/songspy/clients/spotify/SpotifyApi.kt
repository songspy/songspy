package com.songspy.clients.spotify

import com.songspy.clients.spotify.response.PlayingTrackResponseDto
import com.songspy.clients.spotify.response.SpotifySearchResponseDto
import com.songspy.commons.extension.BearerAuth
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "spotify-api", url = "\${spotify-api.url}")
interface SpotifyApi {
    @GetMapping("/v1/me/player/currently-playing")
    fun getCurrentlyPlayingTrack(@RequestHeader("Authorization") auth: BearerAuth): PlayingTrackResponseDto

    @GetMapping("/v1/search")
    fun search(
        @RequestHeader("Authorization") auth: BearerAuth,
        @RequestParam("q") keyword: String,
        @RequestParam type: String = "playlist",
        @RequestParam market: String = "KR",
        @RequestParam limit: Int = 20,
        @RequestParam offset: Int
    ): SpotifySearchResponseDto
}
