package com.songspy.quiz.core.domains.playlist

import com.songspy.clients.spotify.SpotifyClient
import org.springframework.stereotype.Service

@Service
class TrackService(
    private val spotifyClient: SpotifyClient,
    private val playlistTrackResultMapper: PlaylistTrackResultMapper
) {
    fun getByPlaylistId(playlistId: String, offset: Int): PlaylistTrackResult {
        // TODO token change (일단 mocking)
        val spotifyToken = "token"
        val playlistTrackResponse = spotifyClient.getPlaylistTracks(token = spotifyToken, playlistId = playlistId, offset = offset)
            .onFailure { }
            .getOrThrow()
        return playlistTrackResultMapper.map(playlistTrackResponse)
    }
}
