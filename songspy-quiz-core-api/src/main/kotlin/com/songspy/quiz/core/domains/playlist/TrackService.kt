package com.songspy.quiz.core.domains.playlist

import org.springframework.stereotype.Service

@Service
class TrackService(
    private val trackFetcher: SpotifyTrackFetcher
) {
    fun getByPlaylistId(playlistId: String, offset: Int): PlaylistTrackResult {
        return trackFetcher.fetchByPlaylistIdAndOffset(playlistId, offset)
    }
}
