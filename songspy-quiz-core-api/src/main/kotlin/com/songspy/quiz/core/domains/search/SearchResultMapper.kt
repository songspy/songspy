package com.songspy.quiz.core.domains.search

import com.songspy.clients.spotify.response.SpotifySearchResponseDto
import com.songspy.quiz.core.support.spotify.SpotifySearchUtils
import org.springframework.stereotype.Component

@Component
class SearchResultMapper {
    fun map(response: SpotifySearchResponseDto): SearchResult {
        return SearchResult(
            cursor = SpotifySearchCursor(response.playlists.next),
            playlists = response.playlists.items.map {
                SearchResult.PlaylistSearchResult(
                    id = it.id,
                    title = it.name,
                    image = SpotifySearchUtils.getImage(it.tracks.images)
                )
            }
        )
    }
}
