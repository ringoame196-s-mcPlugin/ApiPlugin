package com.github.ringoame196_s_mcPlugin.handler.impl

import com.github.ringoame196_s_mcPlugin.handler.base.BaseListInfoHandler
import com.github.ringoame196_s_mcPlugin.service.PluginInfoManager
import org.bukkit.Bukkit
import org.bukkit.plugin.Plugin

class PluginsHandler : BaseListInfoHandler<Plugin>() {
    override fun getTargets(): Collection<Plugin> {
        return Bukkit.getPluginManager().plugins.toList()
    }

    override fun toMap(target: Plugin): Map<String, *> =
        PluginInfoManager.getPluginInfo(target).toMap()
}
