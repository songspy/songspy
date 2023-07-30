package com.songspy.core.domains.user

data class UserWithToken(
    val id: Long,
    val nickName: String?,
    val hasSpotify: Boolean,
    val profileImageUrl: String?,
    val token: String
)
