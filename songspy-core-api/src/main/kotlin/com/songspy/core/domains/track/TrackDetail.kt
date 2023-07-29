package com.songspy.core.domains.track

import com.songspy.core.domains.user.UserProfile

data class TrackDetail(
    val track: Track,
    val profile: UserProfile
)
