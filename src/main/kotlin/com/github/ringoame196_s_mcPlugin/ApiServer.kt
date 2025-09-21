package com.github.ringoame196_s_mcPlugin

import com.sun.net.httpserver.HttpServer
import org.bukkit.Bukkit
import java.net.InetSocketAddress

object ApiServer {
    private var server: HttpServer? = null
    private const val PORT = 8080

    fun startup() {
        if (server != null) return
        server = HttpServer.create(InetSocketAddress(PORT), 0)

        server?.createContext("/test", TestHandler())
        server?.createContext("/player", PlayerHandler())
        server?.createContext("/players", PlayersHandler())

        server?.executor = null // シンプルなスレッド処理
        server?.start()

        Bukkit.getLogger().info("API サーバー起動: http://localhost:8080")
    }

    fun stop() {
        server ?: return
        server!!.stop(1)
    }
}
