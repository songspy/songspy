package com.songspy.core.domains.auth.spotify

import com.songspy.core.domains.user.UserAuthenticator
import jakarta.transaction.Transactional
import org.springframework.stereotype.Component

@Component
class SpotifyTokenCreator(
    private val tokenCreator: TokenCreator,
    private val userUpdater: UserAuthenticator
) {
    @Transactional
    fun create(creation: SpotifyTokenCreation) {
        tokenCreator.create(creation)
        userUpdater.authenticateSpotifyAccount(creation.userId)
    }
}
