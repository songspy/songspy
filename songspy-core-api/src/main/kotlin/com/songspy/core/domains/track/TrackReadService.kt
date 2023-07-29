package com.songspy.core.domains.track

import org.springframework.stereotype.Service

@Service
class TrackReadService(
    private val trackReader: CurrentTrackReader
) {
    fun readCurrentPlaying(): List<Track> {
        val tracks = trackReader.readAll()
        return getUniqueByUserId(tracks)
    }

    private fun getUniqueByUserId(tracks: List<Track>): List<Track> {
        return tracks.groupBy { it.userId }
            .map { it.value[0] }
    }
}
