package com.songspy.core.batch.spotify.token

import com.songspy.storage.db.core.spotify.token.TokenEntity
import org.springframework.stereotype.Component

@Component
class TokenBucketMapper {
    fun map(entity: TokenEntity): TokenBucket {
        return TokenBucket(
            id = entity.id,
            accessToken = entity.accessToken,
            refreshToken = entity.refreshToken,
            userId = entity.userId
        )
    }
}
