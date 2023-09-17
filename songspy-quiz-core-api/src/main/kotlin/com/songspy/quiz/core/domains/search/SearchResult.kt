package com.songspy.quiz.core.domains.search

data class SearchResult(
    val cursor: SpotifySearchCursor?,
    val playlists: List<PlaylistSearchResult>
) {
    data class PlaylistSearchResult(
        val id: String,
        val title: String,
        val image: String
    )
}
