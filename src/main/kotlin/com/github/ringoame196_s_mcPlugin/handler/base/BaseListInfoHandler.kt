package com.github.ringoame196_s_mcPlugin.handler.base

import com.github.ringoame196_s_mcPlugin.api.JsonResponder
import com.sun.net.httpserver.HttpExchange
import com.sun.net.httpserver.HttpHandler

abstract class BaseListInfoHandler<T> : HttpHandler {
    // サブクラスが対象リストを返す処理を実装
    abstract fun getTargets(): Collection<T>

    // Map に変換する処理をサブクラスが提供
    abstract fun toMap(target: T): Map<String, *>

    override fun handle(exchange: HttpExchange?) {
        exchange ?: return

        val list = getTargets().map { toMap(it) }

        JsonResponder.respondJson(exchange, 200, list)
    }
}
