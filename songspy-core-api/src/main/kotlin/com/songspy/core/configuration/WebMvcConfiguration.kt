package com.songspy.core.configuration

import com.songspy.core.configuration.interceptor.BearerAuthorizationInterceptor
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebMvcConfiguration(
    private val bearerAuthorizationInterceptor: BearerAuthorizationInterceptor
) : WebMvcConfigurer {
    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(bearerAuthorizationInterceptor)
            .excludePathPatterns("/v1/songspy/google-auth")
            .excludePathPatterns("/v1/songspy/tracks/**")
    }
}
