package com.songspy.core.domains.user

import com.songspy.storage.db.core.user.UserEntity
import org.springframework.stereotype.Component

@Component
class UserMapper {
    fun map(entity: UserEntity): User {
        return User(
            id = entity.id,
            nickName = entity.nickName,
            hasSpotify = entity.hasSpotify,
            profileImageUrl = entity.profileImageUrl
        )
    }
}
