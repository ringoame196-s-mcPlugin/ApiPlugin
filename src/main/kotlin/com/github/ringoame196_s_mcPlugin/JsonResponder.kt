package com.github.ringoame196_s_mcPlugin

import com.sun.net.httpserver.HttpExchange

object JsonResponder {
    fun respondJson(exchange: HttpExchange, statusCode: Int, data: Map<String, Any?>) {
        val json = JsonManager.jsonString(data)
        exchange.responseHeaders.add("Content-Type", "application/json; charset=utf-8")
        val bytes = json.toByteArray(Charsets.UTF_8)
        exchange.sendResponseHeaders(statusCode, bytes.size.toLong())
        exchange.responseBody.use { it.write(bytes) }
    }
}
