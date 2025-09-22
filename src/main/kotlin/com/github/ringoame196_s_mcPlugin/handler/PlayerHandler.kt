package com.github.ringoame196_s_mcPlugin.handler

import com.github.ringoame196_s_mcPlugin.player.PlayerInfoManager
import com.github.ringoame196_s_mcPlugin.api.JsonResponder
import com.sun.net.httpserver.HttpExchange
import com.sun.net.httpserver.HttpHandler
import org.bukkit.Bukkit

class PlayerHandler : HttpHandler {
    override fun handle(exchange: HttpExchange?) {
        exchange ?: return
        val path = exchange.requestURI.path
        val parts = path.split("/")

        if (parts.size < 3 || parts[2].isEmpty()) {
            JsonResponder.respondJson(exchange, 400, mapOf("error" to "Player name is missing"))
            return
        }

        val playerName = parts[2]
        val player = Bukkit.getPlayerExact(playerName)
        if (player == null) {
            JsonResponder.respondJson(exchange, 404, mapOf("error" to "Player not found"))
            return
        }

        val playerInfo = PlayerInfoManager.getPlayerInfo(player)
        JsonResponder.respondJson(exchange, 200, playerInfo.toMap())
    }
}
