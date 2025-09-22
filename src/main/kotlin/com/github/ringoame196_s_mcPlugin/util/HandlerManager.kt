package com.github.ringoame196_s_mcPlugin.util

import com.sun.net.httpserver.HttpExchange

object HandlerManager {
    fun getPathParam(exchange: HttpExchange, index: Int): String? {
        val parts = exchange.requestURI.path.split("/")
        return if (parts.size > index && parts[index].isNotEmpty()) {
            parts[index]
        } else null
    }
}