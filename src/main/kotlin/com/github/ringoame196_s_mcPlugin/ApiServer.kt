package com.github.ringoame196_s_mcPlugin

import com.sun.net.httpserver.HttpServer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json
import org.bukkit.Bukkit
import java.net.InetSocketAddress

object ApiServer {
    private var server: HttpServer? = null
    private const val PORT = 8080

    fun startup() {
        if (server != null) return
        server = HttpServer.create(InetSocketAddress(PORT), 0)

        // プレイヤー一覧エンドポイント
        server?.createContext("/players") { exchange ->
            val players: List<PlayerInfo> = Bukkit.getOnlinePlayers()
                .mapNotNull {
                    McManager.getPlayerInfo(it)
                }
            val json = Json.encodeToString(ListSerializer(PlayerInfo.serializer()), players)

            exchange.sendResponseHeaders(200, json.toByteArray().size.toLong())
            exchange.responseBody.use { it.write(json.toByteArray()) }
        }

        server?.executor = null // シンプルなスレッド処理
        server?.start()

        Bukkit.getLogger().info("API サーバー起動: http://localhost:8080")
    }

    fun stop() {
        server ?: return
        server!!.stop(1)
    }
}
