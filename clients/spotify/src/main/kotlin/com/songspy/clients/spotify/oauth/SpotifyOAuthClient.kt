package com.songspy.clients.spotify.oauth

import com.songspy.clients.spotify.response.AccessTokenResponse
import com.songspy.commons.extension.basicAuth
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class SpotifyOAuthClient(
    private val spotifyOAuthApi: SpotifyOAuthApi,
    @Value("\${spotify-api.client.key}")
    private val clientKey: String,
    @Value("\${spotify-api.secret.key}")
    private val secretKey: String,
    @Value("\${spotify-api.redirect.url}")
    private val redirectUrl: String
) {
    private val logger = LoggerFactory.getLogger(javaClass)

    fun getAccessToken(code: String): Result<AccessTokenResponse> {
        logger.info("[access token] code: $code")
        return runCatching {
            spotifyOAuthApi.getAccessToken(
                auth = basicAuth(clientKey, secretKey),
                code = code,
                redirectUrl = redirectUrl
            )
        }
    }
}
