package com.songspy.core.controller.user

import com.songspy.commons.api.response.CommonApiResponse
import com.songspy.core.controller.user.request.ProfileEditRequestDto
import com.songspy.core.controller.user.response.ProfileEditResponseDto
import com.songspy.core.domains.user.UserEditService
import com.songspy.core.support.Constants
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestAttribute
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/songspy/users")
class UserController(
    private val userEditService: UserEditService
) {
    @PostMapping("/{id}/edit")
    fun edit(
        @PathVariable id: Long,
        @RequestBody body: ProfileEditRequestDto,
        @RequestAttribute(Constants.USER_ID) userId: Long
    ): CommonApiResponse<ProfileEditResponseDto> {
        val nickName = userEditService.edit(body.toDomain(id), userId)
        return CommonApiResponse.success(ProfileEditResponseDto(nickName))
    }
}
