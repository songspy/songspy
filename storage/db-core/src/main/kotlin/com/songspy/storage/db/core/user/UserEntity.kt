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
    var nickName: String? = null,

    @Column(name = "has_spotify")
    var hasSpotify: Boolean = false,

    @Column(name = "third_party_id")
    val thirdPartyId: String?,

    @Column(name = "profile_image_url")
    val profileImageUrl: String? = null
) : BaseEntity() {
    fun authenticateSpotify() {
        this.hasSpotify = true
    }

    fun edit(nickName: String) {
        this.nickName = nickName
    }
}
