package com.github.ringoame196_s_mcPlugin.handler

import com.github.ringoame196_s_mcPlugin.api.JsonResponder
import com.github.ringoame196_s_mcPlugin.plugin.PluginInfoManager
import com.sun.net.httpserver.HttpExchange
import com.sun.net.httpserver.HttpHandler
import org.bukkit.Bukkit

class PluginsHandler : HttpHandler {
    override fun handle(exchange: HttpExchange?) {
        exchange ?: return
        val plugins = Bukkit.getPluginManager().plugins
        val pluginInfoList = mutableListOf<Map<String, *>>()

        for (plugin in plugins) {
            pluginInfoList.add(PluginInfoManager.getPluginInfo(plugin).toMap())
        }
        JsonResponder.respondJson(exchange, 200, pluginInfoList)
    }
}
