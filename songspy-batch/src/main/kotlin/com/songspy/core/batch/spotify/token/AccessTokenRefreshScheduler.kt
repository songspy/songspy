package com.songspy.core.batch.spotify.token

import com.songspy.clients.spotify.oauth.SpotifyOAuthClient
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Async
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class AccessTokenRefreshScheduler(
    private val spotifyOAuthClient: SpotifyOAuthClient,
    private val spotifyTokenReader: SpotifyTokenReader,
    private val spotifyTokenReNewer: SpotifyTokenReNewer
) {
    private val logger = LoggerFactory.getLogger(javaClass)

    @Async
    @Scheduled(fixedDelay = ACCESS_TOKEN_REFRESH_SCHEDULE_TIME)
    fun schedule() {
        logger.info("spotify access token scheduler start")
        val expiredTokens = spotifyTokenReader.readExpired()
        logger.info("expired token: $expiredTokens")
        expiredTokens.forEach {
            updateAccessTokenWithRefreshToken(it)
        }
    }

    private fun updateAccessTokenWithRefreshToken(tokenBucket: TokenBucket) {
        val newAccessToken = spotifyOAuthClient.refresh(tokenBucket.refreshToken)
            .getOrThrow()
            .accessToken
        logger.info("token updated from ${tokenBucket.accessToken} to $newAccessToken")
        spotifyTokenReNewer.renew(tokenBucket.id, newAccessToken)
    }
    companion object {
        private const val ACCESS_TOKEN_REFRESH_SCHEDULE_TIME = 1_000L * 60 * 10 // 10분
    }
}
