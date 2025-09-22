package com.github.ringoame196_s_mcPlugin.handler

import com.github.ringoame196_s_mcPlugin.player.PlayerInfoManager
import org.bukkit.Bukkit
import org.bukkit.entity.Player

class PlayersHandler : BaseListInfoHandler<Player>() {
    override fun getTargets() = Bukkit.getOnlinePlayers()

    override fun toMap(target: Player) =
        PlayerInfoManager.getPlayerInfo(target).toMap()
}
