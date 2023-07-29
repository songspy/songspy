package com.songspy.storage.db.core.user

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<UserEntity, Long> {
    fun findByThirdPartyId(thirdPartyId: String): UserEntity?

    fun findAllByIdIn(ids: List<Long>): List<UserEntity>
}
