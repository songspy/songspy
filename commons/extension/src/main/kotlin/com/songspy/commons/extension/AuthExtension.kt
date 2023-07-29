package com.songspy.commons.extension

import java.util.Base64

typealias BasicAuth = String

typealias BearerAuth = String

fun basicAuth(client: String, secret: String): String = "Basic ${Base64.getEncoder().encodeToString(
    "$client:$secret".toByteArray()
)}"

fun bearerAuth(token: String): String = "Bearer $token"
