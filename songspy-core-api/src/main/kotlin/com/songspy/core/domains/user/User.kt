package com.songspy.core.domains.user

data class User(
    val id: Long,
    val nickName: String?,
    val hasSpotify: Boolean,
    val profileImageUrl: String?
) {
    fun profile(): UserProfile {
        return UserProfile(
            id = id,
            nickName = nickName!!,
            profileImageUrl = profileImageUrl
        )
    }

    fun withToken(token: String): UserWithToken {
        return UserWithToken(
            id = id,
            nickName = nickName,
            hasSpotify = hasSpotify,
            profileImageUrl = profileImageUrl,
            token = token
        )
    }
}
