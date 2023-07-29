package com.songspy.core.domains.user

import com.songspy.storage.db.core.user.UserRepository
import jakarta.transaction.Transactional
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class UserAuthenticator(
    private val userRepository: UserRepository
) {
    @Transactional
    fun authenticateSpotifyAccount(id: Long) {
        userRepository.findByIdOrNull(id)?.authenticateSpotify()
    }
}
