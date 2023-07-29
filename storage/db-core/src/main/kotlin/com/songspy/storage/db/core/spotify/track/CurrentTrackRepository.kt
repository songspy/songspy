package com.songspy.storage.db.core.spotify.track

import org.springframework.data.jpa.repository.JpaRepository

interface CurrentTrackRepository : JpaRepository<CurrentTrackEntity, Long> {
    fun findAllByOrderByCreatedAtDesc(): List<CurrentTrackEntity>
}
