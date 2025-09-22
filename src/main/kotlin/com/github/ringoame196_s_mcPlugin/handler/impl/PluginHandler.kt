package com.github.ringoame196_s_mcPlugin.handler.impl

import com.github.ringoame196_s_mcPlugin.handler.base.BaseSearchInfoHandler
import com.github.ringoame196_s_mcPlugin.model.PluginInfo
import com.github.ringoame196_s_mcPlugin.service.PluginInfoManager
import org.bukkit.Bukkit
import org.bukkit.plugin.Plugin

class PluginHandler(plugin: Plugin) : BaseSearchInfoHandler<PluginInfo>(plugin) {
    override val notFoundMessage: String
        get() = "Plugin not found"

    override fun findTarget(name: String): PluginInfo? {
        val plugin = Bukkit.getPluginManager().getPlugin(name) ?: return null
        return PluginInfoManager.getPluginInfo(plugin)
    }
}
