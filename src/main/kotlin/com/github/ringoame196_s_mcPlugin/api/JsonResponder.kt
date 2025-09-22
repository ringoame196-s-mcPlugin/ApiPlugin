package com.github.ringoame196_s_mcPlugin.api

import com.sun.net.httpserver.HttpExchange

object JsonResponder {
    fun respondJson(exchange: HttpExchange, statusCode: Int, data: Map<String, Any?>) {
        val json = JsonManager.jsonString(data)
        respondJson(exchange, statusCode, json)
    }

    fun respondJson(exchange: HttpExchange, statusCode: Int, data: List<Map<String, Any?>>) {
        val json = JsonManager.jsonString(data)
        respondJson(exchange, statusCode, json)
    }

    private fun respondJson(exchange: HttpExchange, statusCode: Int, json: String) {
        exchange.responseHeaders.add("Content-Type", "application/json; charset=utf-8")
        val bytes = json.toByteArray(Charsets.UTF_8)
        exchange.sendResponseHeaders(statusCode, bytes.size.toLong())
        exchange.responseBody.use { it.write(bytes) }
    }
}
