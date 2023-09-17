package com.songspy.quiz.core.domains.search

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class SpotifySearchCursorTest {
    private val offset = 30

    @Test
    fun `cursor encode`() {
        val cursor = SpotifySearchCursor("https://api.spotify.com/v1/search?query=%ED%9E%99%ED%95%A9&type=playlist&market=KR&locale=ko-KR%2Cko%3Bq%3D0.9%2Cen-US%3Bq%3D0.8%2Cen%3Bq%3D0.7&offset=$offset&limit=20")
        println(cursor.encode())
    }

    @Test
    fun `cursor가 null일 때 offset은 0을 반환한다`() {
        val cursor = SpotifySearchCursor(null)

        val actual = cursor.offset()

        actual shouldBe 0
    }

    @Test
    fun `cursor가 null이 아닌 경우 알맞은 offset을 반환한다`() {
        val cursor = SpotifySearchCursor("aHR0cHM6Ly9hcGkuc3BvdGlmeS5jb20vdjEvc2VhcmNoP3F1ZXJ5PSVFRCU5RSU5OSVFRCU5NSVBOSZ0eXBlPXBsYXlsaXN0Jm1hcmtldD1LUiZsb2NhbGU9a28tS1IlMkNrbyUzQnElM0QwLjklMkNlbi1VUyUzQnElM0QwLjglMkNlbiUzQnElM0QwLjcmb2Zmc2V0PTMwJmxpbWl0PTIw")

        val actual = cursor.offset()

        actual shouldBe offset
    }
}
