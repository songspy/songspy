package com.songspy.quiz.core.domains.search

import com.songspy.clients.spotify.SpotifyClient
import org.springframework.stereotype.Service

@Service
class SearchService(
    private val spotifyClient: SpotifyClient,
    private val searchResultMapper: SearchResultMapper
) {
    fun search(keyword: String, offset: Int): SearchResult {
        // TODO token change (일단 mocking)
        val spotifyToken = "token"
        val searchResponse = spotifyClient.search(token = spotifyToken, keyword = keyword, offset = offset)
            .onFailure {  }
            .getOrThrow()
        return searchResultMapper.map(searchResponse)
    }
}