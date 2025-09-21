package com.github.ringoame196_s_mcPlugin

import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    override fun onEnable() {
        super.onEnable()
        ApiServer.startup()
    }

    override fun onDisable() {
        super.onDisable()
        ApiServer.stop()
    }
}
