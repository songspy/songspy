package com.songspy.storage.db.core.spotify.token

import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime

interface TokenRepository : JpaRepository<TokenEntity, Long> {
    fun findAllByExpiredAtIsLessThan(expiredAt: LocalDateTime): List<TokenEntity>
}
