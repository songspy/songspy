package com.songspy.core.controller.track.response

import com.songspy.core.domains.user.UserProfile

data class UserProfileResponseDto(
    val id: Long,
    val nickName: String,
    val profileImageUrl: String?
) {
    constructor(profile: UserProfile) : this(
        id = profile.id,
        nickName = profile.nickName,
        profileImageUrl = profile.profileImageUrl
    )
}
