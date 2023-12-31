package com.songspy.quiz.core.controller.v1.search.response

import com.songspy.quiz.core.domains.search.SearchResult

data class SongspySearchResponseDto(
    val cursor: String?,
    val playlists: List<PlaylistSearchResponseDto>
) {

    companion object {
        fun from(result: SearchResult): SongspySearchResponseDto {
            return SongspySearchResponseDto(
                cursor = result.cursor?.encode(),
                playlists = result.playlists.map {
                    PlaylistSearchResponseDto(
                        id = it.id,
                        title = it.title,
                        imageUrl = it.image
                    )
                }
            )
        }
    }

    data class PlaylistSearchResponseDto(
        val id: String,
        val title: String,
        val imageUrl: String
    )
}
