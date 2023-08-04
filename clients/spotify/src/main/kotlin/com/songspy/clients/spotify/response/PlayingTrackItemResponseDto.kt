package com.songspy.clients.spotify.response

import com.fasterxml.jackson.annotation.JsonProperty

data class PlayingTrackItemResponseDto(
    val album: AlbumResponseDto,
    val artists: List<ArtistResponseDto>,
    @JsonProperty("external_urls")
    val externalUrls: ExternalUrlResponseDto,
    @JsonProperty("name")
    val title: String,
    @JsonProperty("preview_url")
    val previewUrl: String,
    val id: String
)
