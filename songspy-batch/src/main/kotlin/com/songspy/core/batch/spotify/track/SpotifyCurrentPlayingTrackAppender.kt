package com.songspy.core.batch.spotify.track

import com.songspy.storage.db.core.spotify.track.CurrentTrackRepository
import org.springframework.stereotype.Component

@Component
class SpotifyCurrentPlayingTrackAppender(
    private val currentTrackRepository: CurrentTrackRepository,
    private val spotifyCurrentPlayingTrackMapper: SpotifyCurrentPlayingTrackMapper
) {
    fun append(userId: Long, track: SpotifyCurrentPlayingTrack) {
        val entity = spotifyCurrentPlayingTrackMapper.map(userId, track)
        currentTrackRepository.save(entity)
    }
}
