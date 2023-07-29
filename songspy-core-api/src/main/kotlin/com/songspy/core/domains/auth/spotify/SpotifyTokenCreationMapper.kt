package com.songspy.core.domains.auth.spotify

import com.songspy.clients.spotify.response.AccessTokenResponseDto
import com.songspy.storage.db.core.spotify.token.TokenEntity
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class SpotifyTokenCreationMapper {
    fun map(dto: AccessTokenResponseDto, userId: Long): SpotifyTokenCreation {
        return SpotifyTokenCreation(
            userId = userId,
            accessToken = dto.accessToken,
            refreshToken = dto.refreshToken
        )
    }

    fun map(creation: SpotifyTokenCreation): TokenEntity {
        return TokenEntity(
            userId = creation.userId,
            accessToken = creation.accessToken,
            refreshToken = creation.refreshToken,
            expiredAt = LocalDateTime.now().plusMinutes(60)
        )
    }
}
