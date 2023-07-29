package com.songspy.core.batch.spotify.token

import com.songspy.storage.db.core.spotify.token.TokenRepository
import jakarta.transaction.Transactional
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class SpotifyTokenReNewer(
    private val tokenRepository: TokenRepository
) {
    @Transactional
    fun renew(id: Long, accessToken: String) {
        tokenRepository.findByIdOrNull(id)?.renew(accessToken)
    }
}
