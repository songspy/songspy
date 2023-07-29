package com.songspy.clients.google.oauth

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class GoogleOAuthClient(
    private val googleOAuthApi: GoogleOAuthApi,
    @Value("\${google-api.client.key}")
    private val clientKey: String,
    @Value("\${google-api.secret.key}")
    private val secretKey: String,
    @Value("\${google-api.redirect.url}")
    private val redirectUrl: String
) {
    private val logger = LoggerFactory.getLogger(javaClass)

    fun getAccessToken(code: String): Result<String> {
        logger.info("[google oauth get access code] code: $code")
        return runCatching {
            googleOAuthApi.getAccessToken(
                clientId = clientKey,
                clientSecret = secretKey,
                code = code,
                redirectUrl = redirectUrl
            ).accessToken
        }
    }
}
