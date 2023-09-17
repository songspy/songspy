package com.songspy.clients.spotify

import com.songspy.clients.spotify.response.PlayingTrackResponseDto
import com.songspy.clients.spotify.response.SpotifyPlaylistTrackResponseDto
import com.songspy.clients.spotify.response.SpotifySearchResponseDto
import com.songspy.commons.extension.bearerAuth
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class SpotifyClient(
    private val spotifyApi: SpotifyApi
) {
    private val logger = LoggerFactory.getLogger(javaClass)

    fun getCurrentlyPlayingTrack(token: String): Result<PlayingTrackResponseDto> {
        logger.info("[currently playing track] token: $token")
        return runCatching {
            spotifyApi.getCurrentlyPlayingTrack(
                auth = bearerAuth(token)
            )
        }
    }

    fun search(token: String, keyword: String, offset: Int): Result<SpotifySearchResponseDto> {
        return runCatching {
            spotifyApi.search(
                auth = bearerAuth(token),
                keyword = keyword,
                offset = offset
            )
        }
    }

    fun getPlaylistTracks(token: String, playlistId: String, offset: Int): Result<SpotifyPlaylistTrackResponseDto> {
        return runCatching {
            spotifyApi.getPlaylistTracks(
                auth = bearerAuth(token),
                playlistId = playlistId,
                offset = offset
            )
        }
    }
}
