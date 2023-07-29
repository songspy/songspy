package com.songspy.clients.spotify.oauth

import com.songspy.commons.extension.basicAuth
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
    fun getAccessToken(code: String) {
        val tokenResult = spotifyOAuthApi.getAccessToken(
            auth = basicAuth(clientKey, secretKey),
            code = code,
            redirectUrl = redirectUrl
        )
        println(tokenResult)
    }
}
