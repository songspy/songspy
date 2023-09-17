package com.songspy.quiz.core

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.songspy"])
class QuizCoreApiApplication

fun main(args: Array<String>) {
    runApplication<QuizCoreApiApplication>(*args)
}
