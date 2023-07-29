package com.songspy.core.domains.auth

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.songspy.core.domains.auth.google.GoogleTokenPayload
import java.util.*

data class UserAuth(
    val id: String,
    val email: String
) {
    companion object {
        private val mapper = jacksonObjectMapper()

        fun fromToken(token: String): UserAuth {
            val jwtParts = token.split(".")
            if (jwtParts.size != 3) {
                throw Exception()
            }
            val decoded = String(Base64.getUrlDecoder().decode(jwtParts[1]))
            val payload = mapper.readValue(decoded, GoogleTokenPayload::class.java)
            return UserAuth(
                id = payload.sub,
                email = payload.email
            )
        }
    }
}
