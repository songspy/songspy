package com.songspy.core.batch.spotify.track

import com.songspy.storage.db.core.spotify.track.CurrentTrackRepository
import org.springframework.stereotype.Component

@Component
class SpotifyCurrentPlayingTrackReader(
    private val currentTrackRepository: CurrentTrackRepository,
    private val spotifyCurrentPlayingTrackMapper: SpotifyCurrentPlayingTrackMapper
) {
    fun readByUserIdAndTrackId(userId: Long, trackId: String): SpotifyCurrentPlayingTrack? {
        return currentTrackRepository.findOneByUserIdAndTrackId(userId, trackId)
            ?.let { spotifyCurrentPlayingTrackMapper.map(it) }
    }
}
