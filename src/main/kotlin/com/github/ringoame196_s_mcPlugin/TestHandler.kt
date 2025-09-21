package com.github.ringoame196_s_mcPlugin

import com.sun.net.httpserver.HttpExchange
import com.sun.net.httpserver.HttpHandler

class TestHandler : HttpHandler {
    override fun handle(exchange: HttpExchange) {
        JsonResponder.respondJson(exchange, 200, mapOf("status" to "ok"))
    }
}
