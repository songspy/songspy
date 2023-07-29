package com.songspy.core.domains.auth

import io.jsonwebtoken.Claims
import io.jsonwebtoken.JwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.time.Duration
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*
import javax.crypto.SecretKey

@Component
class JwtTokenHandler(
    private val key: SecretKey
) {
    private val expirationTime = Duration.ofDays(1)

    fun issue(userId: Long): TokenBucket {
        val now = LocalDateTime.now()
        val issuedAt = Date.from(now.atZone(ZoneId.systemDefault()).toInstant())
        val expiredAtLocalDateTime = now.plus(expirationTime)
        val expiredAt = Date.from(expiredAtLocalDateTime.atZone(ZoneId.systemDefault()).toInstant())

        val accessToken = Jwts.builder()
            .claim("userId", userId)
            .setIssuedAt(issuedAt)
            .setExpiration(expiredAt)
            .signWith(key, SignatureAlgorithm.HS256)
            .compact()

        val refreshToken = Jwts.builder()
            .setIssuedAt(issuedAt)
            .setExpiration(expiredAt)
            .signWith(key)
            .compact()

        return TokenBucket(
            accessToken = accessToken,
            refreshToken = refreshToken,
            expiredAt = expiredAtLocalDateTime
        )
    }

    fun decode(token: String): Claims {
        return try {
            Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .body
        } catch (e: JwtException) {
            println(e)
//            throw CoreApiException(ErrorType.INVALID_TOKEN)
            throw e
        }
    }
}
