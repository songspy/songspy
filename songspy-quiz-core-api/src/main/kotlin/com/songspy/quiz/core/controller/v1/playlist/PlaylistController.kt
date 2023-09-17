package com.songspy.quiz.core.controller.v1.playlist

import com.songspy.commons.api.response.CommonApiResponse
import com.songspy.quiz.core.controller.v1.playlist.repsonse.SongspyPlaylistTrackResponseDto
import com.songspy.quiz.core.domains.playlist.TrackService
import com.songspy.quiz.core.domains.search.SpotifyCursor
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/songspy/playlists")
class PlaylistController(
    private val trackService: TrackService
) {
    @GetMapping("/{id}/tracks")
    fun getTracks(
        @PathVariable id: String,
        @RequestParam cursor: String?
    ): CommonApiResponse<SongspyPlaylistTrackResponseDto> {
        val result = trackService.getByPlaylistId(playlistId = id, offset = SpotifyCursor(cursor).offset())
        return CommonApiResponse.success(
            SongspyPlaylistTrackResponseDto.from(result)
        )
    }
}
