package com.github.ringoame196_s_mcPlugin.handler

import com.github.ringoame196_s_mcPlugin.plugin.PluginInfo
import com.github.ringoame196_s_mcPlugin.plugin.PluginInfoManager
import org.bukkit.Bukkit

class PluginHandler : BaseSearchInfoHandler<PluginInfo>() {
    override val notFoundMessage: String
        get() = "Plugin not found"

    override fun findTarget(name: String): PluginInfo? {
        val plugin = Bukkit.getPluginManager().getPlugin(name) ?: return null
        return PluginInfoManager.getPluginInfo(plugin)
    }
}
