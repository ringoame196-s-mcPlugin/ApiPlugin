package com.github.ringoame196_s_mcPlugin.handler.impl

import com.github.ringoame196_s_mcPlugin.api.JsonResponder
import com.github.ringoame196_s_mcPlugin.util.HandlerManager
import com.sun.net.httpserver.HttpExchange
import com.sun.net.httpserver.HttpHandler
import org.bukkit.plugin.Plugin

class TestHandler(private val plugin: Plugin) : HttpHandler {
    override fun handle(exchange: HttpExchange) {
        JsonResponder.respondJson(exchange, 200, mapOf("status" to "ok"))
        HandlerManager.sendAccessMessage(exchange, plugin)
    }
}
