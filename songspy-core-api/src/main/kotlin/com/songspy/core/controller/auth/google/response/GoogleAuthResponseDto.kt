package com.songspy.core.controller.auth.google.response

import com.songspy.core.domains.user.UserWithToken

data class GoogleAuthResponseDto(
    val id: Long,
    val nickName: String?,
    val hasSpotify: Boolean,
    val profileImageUrl: String?,
    val token: String
) {
    constructor(user: UserWithToken) : this(
        id = user.id,
        nickName = user.nickName,
        hasSpotify = user.hasSpotify,
        profileImageUrl = user.profileImageUrl,
        token = user.token
    )
}
