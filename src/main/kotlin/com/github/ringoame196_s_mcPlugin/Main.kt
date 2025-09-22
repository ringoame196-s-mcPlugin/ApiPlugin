package com.github.ringoame196_s_mcPlugin

import com.github.ringoame196_s_mcPlugin.api.ApiServer
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    private val plugin = this
    private val apiServer = ApiServer(plugin)

    override fun onEnable() {
        super.onEnable()
        apiServer.startup()
    }

    override fun onDisable() {
        super.onDisable()
        apiServer.stop()
    }
}
