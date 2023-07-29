package com.songspy.core.domains.auth.spotify

import com.songspy.storage.db.core.spotify.token.TokenEntity
import org.springframework.stereotype.Component

@Component
class SpotifyTokenBucketMapper {
    fun map(entity: TokenEntity): SpotifyTokenBucket {
        return SpotifyTokenBucket(
            id = entity.id,
            accessToken = entity.accessToken,
            refreshToken = entity.refreshToken,
            userId = entity.userId
        )
    }
}
