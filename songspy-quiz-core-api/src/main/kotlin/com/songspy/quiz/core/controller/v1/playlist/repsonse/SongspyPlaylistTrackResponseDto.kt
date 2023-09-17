package com.songspy.quiz.core.controller.v1.playlist.repsonse

import com.songspy.quiz.core.domains.playlist.PlaylistTrackResult

data class SongspyPlaylistTrackResponseDto(
    val cursor: String?,
    val total: Int,
    val tracks: List<SongspyTrackResponseDto>
) {
    companion object {
        fun from(result: PlaylistTrackResult): SongspyPlaylistTrackResponseDto {
            return SongspyPlaylistTrackResponseDto(
                cursor = result.cursor?.encode(),
                total = result.total,
                tracks = result.tracks.map {
                    SongspyTrackResponseDto(
                        id = it.id,
                        title = it.title,
                        artistName = it.artistName,
                        image = it.image,
                        explicit = it.explicit,
                        previewUrl = it.previewUrl
                    )
                }
            )
        }
    }

    data class SongspyTrackResponseDto(
        val id: String,
        val title: String,
        val artistName: String,
        val image: String,
        val explicit: Boolean,
        val previewUrl: String?
    )
}
