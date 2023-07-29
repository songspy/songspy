package com.songspy.core.controller.track

import com.songspy.commons.api.response.CommonApiResponse
import com.songspy.core.controller.track.response.CurrentPlayingTrackResponseDto
import com.songspy.core.domains.track.TrackReadService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/songspy/tracks")
class TrackReadController(
    private val trackReadService: TrackReadService
) {
    @GetMapping("/current-playing")
    fun getCurrentPlaying(): CommonApiResponse<List<CurrentPlayingTrackResponseDto>> {
        val trackDetails = trackReadService.readCurrentPlaying()
        return CommonApiResponse.success(
            data = trackDetails.map { CurrentPlayingTrackResponseDto(it) }
        )
    }
}
