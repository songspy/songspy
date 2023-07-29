package com.songspy.storage.db.core.spotify.token

import com.songspy.storage.db.core.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "spotify_token")
class TokenEntity(
    @Column(name = "ref_user_id")
    val userId: Long,

    @Column(name = "access_token")
    var accessToken: String,

    @Column(name = "refresh_token")
    val refreshToken: String,

    @Column(name = "expired_at")
    var expiredAt: LocalDateTime
) : BaseEntity() {
    fun renew(accessToken: String) {
        this.accessToken = accessToken
        this.expiredAt = LocalDateTime.now().plusMinutes(60)
    }
}
