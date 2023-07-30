package com.songspy.core.domains.user

import org.springframework.stereotype.Service

@Service
class UserEditService(
    private val userEditor: UserEditor
) {
    fun edit(modification: UserProfileModification, tokenUserId: Long): String {
        modification.validateByTokenUserId(tokenUserId)
        val user = userEditor.edit(modification)
        return user.nickName!!
    }
}
