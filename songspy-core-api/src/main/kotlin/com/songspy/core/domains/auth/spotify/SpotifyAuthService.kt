package com.songspy.core.domains.auth.spotify

import com.songspy.clients.spotify.oauth.SpotifyOAuthClient
import org.springframework.stereotype.Service

@Service
class SpotifyAuthService(
    private val spotifyOAuthClient: SpotifyOAuthClient,
    private val spotifyTokenCreator: SpotifyTokenCreator,
    private val spotifyTokenCreationMapper: SpotifyTokenCreationMapper,
    private val spotifyTokenReader: TokenReader
) {
    fun auth(code: String, userId: Long) {
        val spotifyToken = spotifyTokenReader.readByUserId(userId)
        if (spotifyToken != null) {
            return
        }

        val tokenResult = spotifyOAuthClient.getAccessToken(code)
            .onFailure { }
            .getOrThrow()

        spotifyTokenCreator.create(spotifyTokenCreationMapper.map(tokenResult, userId))
    }
}
