package com.songspy.core.controller.user.request

import com.songspy.core.domains.user.UserProfileModification

data class ProfileEditRequestDto(
    val nickName: String
) {
    fun toDomain(id: Long): UserProfileModification {
        return UserProfileModification(
            id = id,
            nickName = nickName
        )
    }
}
