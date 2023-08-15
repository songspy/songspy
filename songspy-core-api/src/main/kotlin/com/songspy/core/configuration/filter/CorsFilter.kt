package com.songspy.core.configuration.filter

import jakarta.servlet.Filter
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.http.HttpHeaders
import org.springframework.stereotype.Component

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
class CorsFilter : Filter {
    private val logger = LoggerFactory.getLogger(javaClass)

    private val allowedHosts = listOf(
        "songsspy",
        "localhost"
    )
    override fun doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) {
        val req = request as HttpServletRequest
        val res = response as HttpServletResponse
        val host = req.getHeader(HttpHeaders.HOST)
        if (canAllow(host)) {
            res.setHeader("Access-Control-Allow-Origin", req.getHeader(HttpHeaders.ORIGIN))
            res.setHeader("Access-Control-Allow-Credentials", "true")
            res.setHeader("Access-Control-Allow-Methods", "*")
            res.setHeader("Access-Control-Max-Age", "3600")
            res.setHeader(
                "Access-Control-Allow-Headers",
                "Origin, X-Requested-With, Content-Type, Accept, Authorization"
            )

            if ("OPTIONS".equals(request.method, ignoreCase = true)) {
                response.status = HttpServletResponse.SC_OK
            } else {
                chain.doFilter(request, response)
            }
        } else {
            logger.info("now allowed request. host: ${req.getHeader(HttpHeaders.HOST)} | origin: ${req.getHeader(HttpHeaders.ORIGIN)}")
            response.status = HttpServletResponse.SC_FORBIDDEN
        }
    }

    private fun canAllow(host: String): Boolean {
        allowedHosts.forEach {
            if (host.contains(it)) {
                return true
            }
        }
        return false
    }
}
