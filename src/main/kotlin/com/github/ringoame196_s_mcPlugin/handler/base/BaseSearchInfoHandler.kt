package com.github.ringoame196_s_mcPlugin.handler.base

import com.github.ringoame196_s_mcPlugin.api.JsonResponder
import com.github.ringoame196_s_mcPlugin.model.Info
import com.github.ringoame196_s_mcPlugin.util.HandlerManager
import com.sun.net.httpserver.HttpExchange
import com.sun.net.httpserver.HttpHandler
import org.bukkit.plugin.Plugin

abstract class BaseSearchInfoHandler<T : Info>(private val plugin: Plugin) : HttpHandler {
    abstract val notFoundMessage: String
    abstract fun findTarget(name: String): T?

    override fun handle(exchange: HttpExchange?) {
        exchange ?: return

        val name = HandlerManager.getPathParam(exchange, 2)
        if (name == null) {
            JsonResponder.respondJson(exchange, 400, mapOf("error" to "Name is missing"))
            return
        }

        val target = findTarget(name)
        if (target == null) {
            JsonResponder.respondJson(exchange, 404, mapOf("error" to notFoundMessage))
            return
        }

        JsonResponder.respondJson(exchange, 200, target.toMap())
        HandlerManager.sendAccessMessage(exchange, plugin)
    }
}
