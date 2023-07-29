package com.songspy.core.configuration

import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.crypto.SecretKey

@Configuration
class JwtConfiguration(
    @Value("\${jwt.secret.key}")
    private val secretKey: String
) {
    @Bean
    fun jwtSecretKey(): SecretKey {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey))
    }
}
