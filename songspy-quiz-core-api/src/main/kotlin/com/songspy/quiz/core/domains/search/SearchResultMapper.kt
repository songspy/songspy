package com.songspy.quiz.core.domains.search

import com.songspy.clients.spotify.response.ImageResponseDto
import com.songspy.clients.spotify.response.SpotifySearchResponseDto
import org.springframework.stereotype.Component

@Component
class SearchResultMapper {
    fun map(response: SpotifySearchResponseDto): SearchResult {
        return SearchResult(
            cursor = null, // TODO resolve cursor from next
            playlists = response.playlists.items.map {
                SearchResult.PlaylistSearchResult(
                    id = it.id,
                    trackId = it.tracks.href, // TODO resolve
                    title = it.name,
                    image = getImage(it.tracks.images)
                )
            }
        )
    }

    private fun getImage(images: List<ImageResponseDto>): String {
        return if (images.isNotEmpty()) {
            images[0].url
        } else {
            "default image"
        }
    }
}