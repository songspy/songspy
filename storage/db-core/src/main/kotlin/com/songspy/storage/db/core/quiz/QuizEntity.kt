package com.songspy.storage.db.core.quiz

import com.songspy.storage.db.core.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "quiz")
class QuizEntity(
    @Column(name = "playlist_id")
    val playlistId: String
) : BaseEntity()
