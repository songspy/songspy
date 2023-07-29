package com.songspy.core.batch.spotify.token

import com.songspy.storage.db.core.spotify.token.TokenRepository
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class SpotifyTokenReader(
    private val tokenRepository: TokenRepository,
    private val tokenBucketMapper: TokenBucketMapper
) {
    fun readExpired(): List<TokenBucket> {
        val tokens = tokenRepository.findAllByExpiredAtIsLessThan(LocalDateTime.now())
        return tokens.map { tokenBucketMapper.map(it) }
    }

    fun readUnExpired(): List<TokenBucket> {
        val tokens = tokenRepository.findAllByExpiredAtIsGreaterThan(LocalDateTime.now())
        return tokens.map { tokenBucketMapper.map(it) }
    }
}
