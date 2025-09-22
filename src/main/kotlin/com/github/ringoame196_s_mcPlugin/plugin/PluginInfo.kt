package com.github.ringoame196_s_mcPlugin.plugin

data class PluginInfo(
    val name: String,
    val version: String,
    val apiVersion: String?,
    val enabled: Boolean
) {
    fun toMap(): Map<String, *> {
        return mapOf(
            "name" to name,
            "version" to version,
            "apiVersion" to apiVersion,
            "enabled" to enabled
        )
    }
}
