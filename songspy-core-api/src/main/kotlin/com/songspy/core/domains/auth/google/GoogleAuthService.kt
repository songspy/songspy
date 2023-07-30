package com.songspy.core.domains.auth.google

import com.songspy.clients.google.GoogleClient
import com.songspy.core.domains.auth.JwtTokenHandler
import com.songspy.core.domains.auth.UserAuth
import com.songspy.core.domains.user.UserCreator
import com.songspy.core.domains.user.UserReader
import com.songspy.core.domains.user.UserWithToken
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class GoogleAuthService(
    private val googleClient: GoogleClient,
    private val userReader: UserReader,
    private val userCreator: UserCreator,
    private val jwtTokenHandler: JwtTokenHandler
) {
    private val logger = LoggerFactory.getLogger(javaClass)

    fun auth(accessToken: String): UserWithToken {
        val googleUser = googleClient.getUser(accessToken)
            .onFailure { println(it) }
            .getOrThrow()
        logger.info("[google oauth success] user: $googleUser")
        val userAuth = UserAuth(id = googleUser.id, email = googleUser.email)
        val user = userReader.readByThirdPartyId(userAuth.id)
        if (user == null) {
            val newUser = userCreator.create(userAuth)
            logger.info("[user created] user: $newUser")
            return newUser.withToken(jwtTokenHandler.issue(newUser.id).accessToken)
        }
        return user.withToken(jwtTokenHandler.issue(user.id).accessToken)
    }
}
