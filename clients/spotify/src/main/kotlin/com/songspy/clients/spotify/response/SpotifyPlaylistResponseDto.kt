package com.songspy.clients.spotify.response

data class SpotifyPlaylistResponseDto(
    val next: String,
    val items: PlaylistDetailResponseDto
) {
    data class PlaylistDetailResponseDto(
        val id: String,
        val name: String,
        val tracks: TrackResponseDto
    ) {
        data class TrackResponseDto(
            val href: String,
            val images: List<ImageResponseDto>
        )
    }
}
