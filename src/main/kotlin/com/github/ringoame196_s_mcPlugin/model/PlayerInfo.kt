package com.github.ringoame196_s_mcPlugin.model

data class PlayerInfo(
    val name: String?,
    val uuid: String?,
    val health: Double?,
    val world: String?,
    val x: Double?,
    val y: Double?,
    val z: Double?
) : Info {
    override fun toMap(): Map<String, *> {
        return mapOf(
            "name" to name,
            "uuid" to uuid,
            "health" to health,
            "world" to world,
            "x" to x,
            "y" to y,
            "z" to z
        )
    }
}
