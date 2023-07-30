package com.songspy.core.configuration.interceptor

import com.songspy.core.domains.auth.JwtTokenHandler
import com.songspy.core.support.Constants
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor

@Component
class BearerAuthorizationInterceptor(
    private val jwtTokenHandler: JwtTokenHandler
) : HandlerInterceptor {

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        val (_, payload) = request.getHeader("Authorization").split(" ")
        val userId = jwtTokenHandler.decode(payload)[Constants.USER_ID]
        request.setAttribute(Constants.USER_ID, userId)
        return true
    }
}
