package com.songspy.core.domains.user

data class User(
    val id: Long,
    val nickName: String?,
    val hasSpotify: Boolean
)
