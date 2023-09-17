package com.songspy.clients.spotify.response

import com.fasterxml.jackson.annotation.JsonProperty

data class SpotifyPlaylistTrackResponseDto(
    val next: String?,
    val total: Int,
    val items: List<SpotifyTrackResponseDto>
) {
    data class SpotifyTrackResponseDto(
        val track: SpotifyTrackDetailResponseDto
    ) {
        data class SpotifyTrackDetailResponseDto(
            val id: String,
            val album: AlbumResponseDto,
            val artists: List<ArtistResponseDto>,
            val explicit: Boolean,
            val name: String,
            @JsonProperty("preview_url")
            val previewUrl: String
        )
    }
}
