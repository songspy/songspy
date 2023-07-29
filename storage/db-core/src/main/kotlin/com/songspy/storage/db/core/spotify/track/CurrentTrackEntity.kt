package com.songspy.storage.db.core.spotify.track

import com.songspy.storage.db.core.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "current_track")
class CurrentTrackEntity(
    @Column(name = "ref_user_id")
    val userId: Long,

    @Column(name = "title")
    val title: String,

    @Column(name = "artist_name")
    val artistName: String,

    @Column(name = "original_url")
    val originalUrl: String,

    @Column(name = "preview_url")
    val previewUrl: String
) : BaseEntity()
