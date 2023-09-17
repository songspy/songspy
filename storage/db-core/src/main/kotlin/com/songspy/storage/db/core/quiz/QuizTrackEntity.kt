package com.songspy.storage.db.core.quiz

import com.songspy.storage.db.core.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "quiz_track")
class QuizTrackEntity(
    @Column(name = "ref_quiz_id")
    val quizId: Long,

    @Column(name = "playlist_id")
    val playlistId: String,

    @Column(name = "track_id")
    val trackId: String,

    @Column(name = "title")
    val title: String,

    @Column(name = "artist_name")
    val artistName: String,

    @Column(name = "image")
    val image: String,

    @Column(name = "preview_url")
    val previewUrl: String
) : BaseEntity()
