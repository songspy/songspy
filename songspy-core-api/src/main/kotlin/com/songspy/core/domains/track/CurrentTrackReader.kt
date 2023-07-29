package com.songspy.core.domains.track

import com.songspy.storage.db.core.spotify.track.CurrentTrackRepository
import org.springframework.stereotype.Component

@Component
class CurrentTrackReader(
    private val trackRepository: CurrentTrackRepository,
    private val trackMapper: TrackMapper
) {
    fun readAll(): List<Track> {
        return trackRepository.findAllByOrderByCreatedAtDesc().map {
            trackMapper.map(it)
        }
    }
}
