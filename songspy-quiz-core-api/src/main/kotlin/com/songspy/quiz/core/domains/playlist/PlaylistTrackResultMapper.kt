package com.songspy.quiz.core.domains.playlist

import com.songspy.clients.spotify.response.SpotifyPlaylistTrackResponseDto
import com.songspy.quiz.core.domains.search.SpotifyCursor
import com.songspy.quiz.core.support.spotify.SpotifySearchUtils
import org.springframework.stereotype.Component

@Component
class PlaylistTrackResultMapper {
    fun map(response: SpotifyPlaylistTrackResponseDto): PlaylistTrackResult {
        return PlaylistTrackResult(
            cursor = SpotifyCursor(response.next),
            total = response.total,
            tracks = response.items.map {
                PlaylistTrackResult.TrackResult(
                    id = it.track.id,
                    title = it.track.name,
                    artistName = it.track.artists[0].name,
                    image = SpotifySearchUtils.getImage(it.track.album.images),
                    explicit = it.track.explicit,
                    previewUrl = it.track.previewUrl
                )
            }
        )
    }
}
