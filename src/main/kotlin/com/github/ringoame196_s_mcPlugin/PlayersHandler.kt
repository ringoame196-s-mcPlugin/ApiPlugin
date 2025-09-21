package com.github.ringoame196_s_mcPlugin

import com.sun.net.httpserver.HttpExchange
import com.sun.net.httpserver.HttpHandler
import org.bukkit.Bukkit

class PlayersHandler : HttpHandler {
    override fun handle(exchange: HttpExchange?) {
        exchange ?: return
        val players = Bukkit.getOnlinePlayers()
        val playerInfoList = mutableListOf<Map<String, *>>()

        for (player in players) {
            playerInfoList.add(PlayerInfoManager.getPlayerInfo(player).toMap())
        }
        JsonResponder.respondJson(exchange, 200, playerInfoList)
    }
}
