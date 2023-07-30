package com.songspy.core.domains.user

import com.songspy.storage.db.core.user.UserRepository
import jakarta.transaction.Transactional
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class UserEditor(
    private val userRepository: UserRepository,
    private val userMapper: UserMapper
) {
    @Transactional
    fun edit(modification: UserProfileModification): User {
        return userRepository.findByIdOrNull(modification.id)
            ?.let {
                it.edit(modification.nickName)
                userMapper.map(it)
            }
            ?: throw Exception()
    }
}
