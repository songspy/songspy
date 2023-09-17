package com.songspy.storage.db.core.quiz

import org.springframework.data.jpa.repository.JpaRepository

interface QuizTrackRepository : JpaRepository<QuizTrackEntity, Long> {
    fun findAllByQuizId(quizId: Long): List<QuizTrackEntity>
}
