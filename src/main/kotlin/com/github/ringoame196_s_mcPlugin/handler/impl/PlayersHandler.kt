package com.github.ringoame196_s_mcPlugin.handler.impl

import com.github.ringoame196_s_mcPlugin.handler.base.BaseListInfoHandler
import com.github.ringoame196_s_mcPlugin.service.PlayerInfoManager
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.plugin.Plugin

class PlayersHandler(plugin: Plugin) : BaseListInfoHandler<Player>(plugin) {
    override fun getTargets() = Bukkit.getOnlinePlayers()

    override fun toMap(target: Player) =
        PlayerInfoManager.getPlayerInfo(target).toMap()
}
