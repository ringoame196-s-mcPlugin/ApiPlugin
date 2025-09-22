package com.github.ringoame196_s_mcPlugin.plugin

import org.bukkit.plugin.Plugin

object PluginInfoManager {
    fun getPluginInfo(plugin: Plugin): PluginInfo {
        val description = plugin.description
        val name = description.name
        val version = description.version
        val apiVersion = description.apiVersion
        val enabled = plugin.isEnabled
        return PluginInfo(
            name,
            version,
            apiVersion,
            enabled
        )
    }
}
