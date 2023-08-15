package com.songspy.core.domains.track

import com.songspy.core.domains.user.UserReader
import org.springframework.stereotype.Service

@Service
class TrackReadService(
    private val trackReader: CurrentTrackReader,
    private val userReader: UserReader,
    private val trackDetailAggregator: TrackDetailAggregator
) {
    fun readCurrentPlaying(): List<TrackDetail> {
//        val tracks = getUniqueByUserId(trackReader.readAll())
        val tracks = trackReader.readAll()
        val userProfiles = userReader.readAllByUserIdIn(tracks.map { it.userId })
            .map { it.profile() }
        return trackDetailAggregator.aggregate(tracks, userProfiles)
            .take(40)
    }

    private fun getUniqueByUserId(tracks: List<Track>): List<Track> {
        return tracks.groupBy { it.userId }
            .map { it.value[0] }
    }
}
