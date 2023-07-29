package com.songspy.core.domains.auth

import com.songspy.storage.db.core.user.UserEntity
import org.springframework.stereotype.Component

@Component
class UserAuthMapper {
    fun map(auth: UserAuth): UserEntity {
        return UserEntity(
            email = auth.email,
            thirdPartyId = auth.id
        )
    }
}
