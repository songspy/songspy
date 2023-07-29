package com.songspy.core.domains.user

data class UserProfile(
    val id: Long,
    val nickName: String,
    val profileImageUrl: String?
)
