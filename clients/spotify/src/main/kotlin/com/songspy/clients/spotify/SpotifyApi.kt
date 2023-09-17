package com.songspy.clients.spotify

import com.songspy.clients.spotify.response.PlayingTrackResponseDto
import com.songspy.clients.spotify.response.SpotifyPlaylistTrackResponseDto
import com.songspy.clients.spotify.response.SpotifySearchResponseDto
import com.songspy.commons.extension.BearerAuth
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
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

    @GetMapping("/v1/playlists/{playlist_id}/tracks")
    fun getPlaylistTracks(
        @RequestHeader("Authorization") auth: BearerAuth,
        @PathVariable("playlist_id") playlistId: String,
        @RequestParam market: String = "KR",
        @RequestParam fields: String = "next,total,items(track.id, track.album.images, track.artists.name, track.explicit, track.name, track.preview_url)",
        @RequestParam limit: Int = 20,
        @RequestParam offset: Int
    ): SpotifyPlaylistTrackResponseDto
}
