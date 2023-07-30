package com.songspy.core.domains.user

data class UserProfileModification(
    val id: Long,
    val nickName: String
) {
    fun validateByTokenUserId(userId: Long) {
        if (id != userId) {
            throw Exception()
        }
    }
}
