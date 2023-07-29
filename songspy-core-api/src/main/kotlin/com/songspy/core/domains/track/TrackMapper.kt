package com.songspy.core.domains.track

import com.songspy.storage.db.core.spotify.track.CurrentTrackEntity
import org.springframework.stereotype.Component

@Component
class TrackMapper {
    fun map(entity: CurrentTrackEntity): Track {
        return Track(
            id = entity.id,
            createdAt = entity.createdAt,
            userId = entity.userId,
            title = entity.title,
            artistName = entity.artistName,
            originalUrl = entity.originalUrl,
            previewUrl = entity.previewUrl,
            albumImageUrl = entity.albumImageUrl
        )
    }
}
