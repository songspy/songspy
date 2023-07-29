package com.songspy.core.domains.auth.spotify

import com.songspy.storage.db.core.spotify.token.TokenRepository
import org.springframework.stereotype.Component

@Component
class TokenReader(
    private val tokenRepository: TokenRepository,
    private val tokenBucketMapper: SpotifyTokenBucketMapper
) {
    fun readByUserId(userId: Long): SpotifyTokenBucket? {
        return tokenRepository.findByUserId(userId)
            ?.let { tokenBucketMapper.map(it) }
    }
}
