package com.github.ringoame196_s_mcPlugin.api

import com.github.ringoame196_s_mcPlugin.handler.impl.PlayerHandler
import com.github.ringoame196_s_mcPlugin.handler.impl.PlayersHandler
import com.github.ringoame196_s_mcPlugin.handler.impl.PluginHandler
import com.github.ringoame196_s_mcPlugin.handler.impl.PluginsHandler
import com.github.ringoame196_s_mcPlugin.handler.impl.TestHandler
import com.sun.net.httpserver.HttpServer
import org.bukkit.Bukkit
import org.bukkit.plugin.Plugin
import java.net.InetSocketAddress

class ApiServer(private val plugin: Plugin) {
    private var server: HttpServer? = null
    private val PORT = 8080

    fun startup() {
        if (server != null) return
        server = HttpServer.create(InetSocketAddress(PORT), 0)

        server?.createContext("/test", TestHandler(plugin))
        server?.createContext("/player", PlayerHandler(plugin))
        server?.createContext("/players", PlayersHandler(plugin))
        server?.createContext("/plugin", PluginHandler(plugin))
        server?.createContext("/plugins", PluginsHandler(plugin))

        server?.executor = null // シンプルなスレッド処理
        server?.start()

        Bukkit.getLogger().info("API サーバー起動: http://localhost:8080")
    }

    fun stop() {
        server ?: return
        server!!.stop(1)
    }
}
