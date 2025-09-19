package com.github.ringoame196_s_mcPlugin

import kotlinx.serialization.Serializable

@Serializable
data class PlayerInfo(
    val name: String?,
    val health: Double?,
    val world: String?,
    val x: Double?,
    val y: Double?,
    val z: Double?
)
