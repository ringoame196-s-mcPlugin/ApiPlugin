package com.github.ringoame196_s_mcPlugin.handler

import com.github.ringoame196_s_mcPlugin.api.JsonResponder
import com.github.ringoame196_s_mcPlugin.plugin.PluginInfoManager
import com.sun.net.httpserver.HttpExchange
import com.sun.net.httpserver.HttpHandler
import org.bukkit.Bukkit

class PluginHandler : HttpHandler {
    override fun handle(exchange: HttpExchange?) {
        exchange ?: return
        val path = exchange.requestURI.path
        val parts = path.split("/")

        if (parts.size < 3 || parts[2].isEmpty()) {
            JsonResponder.respondJson(exchange, 400, mapOf("error" to "Player name is missing"))
            return
        }

        val pluginName = parts[2]
        val plugin = Bukkit.getPluginManager().getPlugin(pluginName)

        if (plugin == null) {
            JsonResponder.respondJson(exchange, 404, mapOf("error" to "Plugin not found"))
            return
        }
        val pluginInfo = PluginInfoManager.getPluginInfo(plugin)
        JsonResponder.respondJson(exchange, 200, pluginInfo.toMap())
    }
}
