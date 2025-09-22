package com.github.ringoame196_s_mcPlugin.service

import com.github.ringoame196_s_mcPlugin.model.PlayerInfo
import org.bukkit.entity.Player

object PlayerInfoManager {
    fun getPlayerInfo(player: Player): PlayerInfo {
        val location = player.location
        return PlayerInfo(
            player.name,
            player.uniqueId.toString(),
            player.health,
            location.world?.name,
            location.x,
            location.y,
            location.z
        )
    }
}
