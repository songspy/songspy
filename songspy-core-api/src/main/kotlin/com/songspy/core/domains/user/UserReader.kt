package com.songspy.core.domains.user

import com.songspy.storage.db.core.user.UserRepository
import org.springframework.stereotype.Component

@Component
class UserReader(
    private val userRepository: UserRepository,
    private val userMapper: UserMapper
) {
    fun readByThirdPartyId(thirdPartyId: String): User? {
        return userRepository.findByThirdPartyId(thirdPartyId)
            ?.let { userMapper.map(it) }
    }
}
