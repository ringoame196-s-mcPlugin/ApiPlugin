package com.github.ringoame196_s_mcPlugin.handler.base

import com.github.ringoame196_s_mcPlugin.api.JsonResponder
import com.github.ringoame196_s_mcPlugin.util.HandlerManager
import com.sun.net.httpserver.HttpExchange
import com.sun.net.httpserver.HttpHandler
import org.bukkit.plugin.Plugin

abstract class BaseListInfoHandler<T>(private val plugin: Plugin) : HttpHandler {
    // サブクラスが対象リストを返す処理を実装
    abstract fun getTargets(): Collection<T>

    // Map に変換する処理をサブクラスが提供
    abstract fun toMap(target: T): Map<String, *>

    override fun handle(exchange: HttpExchange?) {
        exchange ?: return

        val list = getTargets().map { toMap(it) }

        JsonResponder.respondJson(exchange, 200, list)
        HandlerManager.sendAccessMessage(exchange, plugin)
    }
}
