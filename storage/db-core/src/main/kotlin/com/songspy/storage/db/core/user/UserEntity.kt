package com.songspy.storage.db.core.user

import com.songspy.storage.db.core.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "user")
class UserEntity(
    @Column(name = "email")
    val email: String,

    @Column(name = "nick_name")
    val nickName: String? = null,

    @Column(name = "has_spotify")
    val hasSpotify: Boolean = false,

    @Column(name = "third_party_id")
    val thirdPartyId: String?
) : BaseEntity()
