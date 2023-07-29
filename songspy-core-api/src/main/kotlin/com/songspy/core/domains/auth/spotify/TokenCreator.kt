package com.songspy.core.domains.auth.spotify

import com.songspy.storage.db.core.spotify.token.TokenRepository
import org.springframework.stereotype.Component

@Component
class TokenCreator(
    private val tokenRepository: TokenRepository,
    private val tokenCreationMapper: SpotifyTokenCreationMapper
) {
    fun create(creation: SpotifyTokenCreation) {
        tokenRepository.save(tokenCreationMapper.map(creation))
    }
}
