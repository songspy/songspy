package com.songspy.quiz.core.domains.search

data class SearchResult(
    val cursor: String?,
    val playlists: List<PlaylistSearchResult>
) {
    data class PlaylistSearchResult(
        val id: String,
        val trackId: String,
        val title: String,
        val image: String
    )
}