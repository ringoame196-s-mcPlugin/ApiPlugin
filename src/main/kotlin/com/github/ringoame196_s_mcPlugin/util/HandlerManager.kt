package com.github.ringoame196_s_mcPlugin.util

import com.sun.net.httpserver.HttpExchange
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.plugin.Plugin

object HandlerManager {
    fun getPathParam(exchange: HttpExchange, index: Int): String? {
        val parts = exchange.requestURI.path.split("/")
        return if (parts.size > index && parts[index].isNotEmpty()) {
            parts[index]
        } else null
    }

    fun sendAccessMessage(exchange: HttpExchange, plugin: Plugin) {
        val remoteAddress = exchange.remoteAddress
        val message = "[${plugin.name}] ${remoteAddress.address.hostAddress}から「/${getPathParam(exchange,1)}」にアクセスされました"
        val players = Bukkit.getOnlinePlayers()
        plugin.logger.info(message)
        for (player in players) {
            if (!player.isOp) continue
            player.sendMessage("${ChatColor.DARK_GRAY}$message")
        }
    }
}
