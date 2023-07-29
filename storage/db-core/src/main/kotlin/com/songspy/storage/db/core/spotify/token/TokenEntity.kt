package com.songspy.storage.db.core.spotify.token

import com.songspy.storage.db.core.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "spotify-token")
class TokenEntity(
    @Column(name = "ref_user_id")
    val userId: Long,

    @Column(name = "access_token")
    val accessToken: String,

    @Column(name = "refresh_token")
    val refreshToken: String,

    @Column(name = "expired_at")
    val expiredAt: LocalDateTime
) : BaseEntity()
