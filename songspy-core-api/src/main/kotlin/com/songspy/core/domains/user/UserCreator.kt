package com.songspy.core.domains.user

import com.songspy.core.domains.auth.UserAuth
import com.songspy.core.domains.auth.UserAuthMapper
import com.songspy.storage.db.core.user.UserRepository
import org.springframework.stereotype.Component

@Component
class UserCreator(
    private val userRepository: UserRepository,
    private val userAuthMapper: UserAuthMapper,
    private val userMapper: UserMapper
) {
    fun create(auth: UserAuth): User {
        val entity = userRepository.save(userAuthMapper.map(auth))
        return userMapper.map(entity)
    }
}
