package com.songspy.quiz.core.domains.search

import java.net.URL
import java.util.Base64

data class SpotifySearchCursor(
    val cursor: String?
) {

    fun encode(): String? {
        return cursor?.let { encoder.encodeToString(it.toByteArray()) }
    }

    fun offset(): Int {
        if (cursor == null) return 0
        val decoded = String(decoder.decode(cursor))
        val queryParams = URL(decoded).query.split("&")
            .associate {
                val (key, value) = it.split("=")
                key to value
            }
        return queryParams["offset"]?.toIntOrNull() ?: 0
    }

    companion object {
        private val encoder = Base64.getEncoder()
        private val decoder = Base64.getDecoder()
    }
}
