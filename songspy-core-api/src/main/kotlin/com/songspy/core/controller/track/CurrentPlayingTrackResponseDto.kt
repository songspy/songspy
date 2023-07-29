package com.songspy.core.controller.track

import com.songspy.core.domains.track.TrackDetail

data class CurrentPlayingTrackResponseDto(
    val track: TrackDetailResponseDto,
    val user: UserProfileResponseDto
) {
    constructor(detail: TrackDetail) : this(
        track = TrackDetailResponseDto(detail.track),
        user = UserProfileResponseDto(detail.profile)
    )
}
