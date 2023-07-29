package com.songspy.core.domains.auth.google

import com.songspy.clients.google.oauth.GoogleOAuthClient
import com.songspy.core.domains.auth.JwtTokenHandler
import com.songspy.core.domains.auth.UserAuth
import com.songspy.core.domains.user.UserCreator
import com.songspy.core.domains.user.UserReader
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class GoogleAuthService(
    private val googleOAuthClient: GoogleOAuthClient,
    private val userReader: UserReader,
    private val userCreator: UserCreator,
    private val jwtTokenHandler: JwtTokenHandler
) {
    private val logger = LoggerFactory.getLogger(javaClass)

    fun auth(code: String): String {
        val token = googleOAuthClient.getAccessToken(code)
            .onFailure { println(it) }
            .getOrThrow()
        logger.info("google oauth success: id: $token")
        val userAuth = UserAuth.fromToken(token)
        val user = userReader.readByThirdPartyId(userAuth.id)
        if (user == null) {
            val newUser = userCreator.create(userAuth)
            return jwtTokenHandler.issue(newUser.id).accessToken
        }
        return jwtTokenHandler.issue(user.id).accessToken
    }
}
