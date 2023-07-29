package com.songspy.core.domains.track

import com.songspy.core.domains.user.UserProfile
import org.springframework.stereotype.Component

@Component
class TrackDetailAggregator {
    fun aggregate(tracks: List<Track>, profile: List<UserProfile>): List<TrackDetail> {
        return tracks.map { track ->
            TrackDetail(
                track = track,
                profile = profile.find { it.id == track.userId }!!
            )
        }
    }
}
