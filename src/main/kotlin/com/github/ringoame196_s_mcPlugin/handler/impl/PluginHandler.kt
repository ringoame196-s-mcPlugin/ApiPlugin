package com.github.ringoame196_s_mcPlugin.handler.impl

import com.github.ringoame196_s_mcPlugin.handler.base.BaseSearchInfoHandler
import com.github.ringoame196_s_mcPlugin.model.PluginInfo
import com.github.ringoame196_s_mcPlugin.service.PluginInfoManager
import org.bukkit.Bukkit

class PluginHandler : BaseSearchInfoHandler<PluginInfo>() {
    override val notFoundMessage: String
        get() = "Plugin not found"

    override fun findTarget(name: String): PluginInfo? {
        val plugin = Bukkit.getPluginManager().getPlugin(name) ?: return null
        return PluginInfoManager.getPluginInfo(plugin)
    }
}
