package com.songspy.core.batch.spotify.track

import com.songspy.clients.spotify.response.PlayingTrackItemResponseDto
import com.songspy.storage.db.core.spotify.track.CurrentTrackEntity
import org.springframework.stereotype.Component

@Component
class SpotifyCurrentPlayingTrackMapper {
    fun map(dto: PlayingTrackItemResponseDto): SpotifyCurrentPlayingTrack {
        return SpotifyCurrentPlayingTrack(
            title = dto.title,
            artistName = dto.artists.getOrNull(0)?.name ?: "",
            originalUrl = dto.externalUrls.spotify,
            previewUrl = dto.previewUrl,
            albumImageUrl = dto.album.images.getOrNull(0)?.url ?: ""
        )
    }

    fun map(userId: Long, track: SpotifyCurrentPlayingTrack): CurrentTrackEntity {
        return CurrentTrackEntity(
            userId = userId,
            title = track.title,
            artistName = track.artistName,
            originalUrl = track.originalUrl,
            previewUrl = track.previewUrl,
            albumImageUrl = track.albumImageUrl
        )
    }
}
