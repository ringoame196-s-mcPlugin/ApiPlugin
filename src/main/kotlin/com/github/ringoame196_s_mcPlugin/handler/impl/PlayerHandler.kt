package com.github.ringoame196_s_mcPlugin.handler.impl

import com.github.ringoame196_s_mcPlugin.handler.base.BaseSearchInfoHandler
import com.github.ringoame196_s_mcPlugin.model.PlayerInfo
import com.github.ringoame196_s_mcPlugin.service.PlayerInfoManager
import org.bukkit.Bukkit

class PlayerHandler : BaseSearchInfoHandler<PlayerInfo>() {
    override val notFoundMessage: String
        get() = "Player not found"

    override fun findTarget(name: String): PlayerInfo? {
        val player = Bukkit.getPlayer(name) ?: return null
        return PlayerInfoManager.getPlayerInfo(player)
    }
}
