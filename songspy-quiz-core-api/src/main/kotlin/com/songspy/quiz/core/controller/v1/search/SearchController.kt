package com.songspy.quiz.core.controller.v1.search

import com.songspy.commons.api.response.CommonApiResponse
import com.songspy.quiz.core.controller.v1.search.response.SongspySearchResponseDto
import com.songspy.quiz.core.domains.search.SearchService
import com.songspy.quiz.core.domains.search.SpotifySearchCursor
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/songspy/search")
class SearchController(
    private val searchService: SearchService
) {
    @GetMapping
    fun search(
        @RequestParam keyword: String,
        @RequestParam cursor: String?
    ): CommonApiResponse<SongspySearchResponseDto> {
        val searchResult = searchService.search(keyword = keyword, offset = SpotifySearchCursor(cursor).offset())
        return CommonApiResponse.success(
            SongspySearchResponseDto.from(searchResult)
        )
    }
}
