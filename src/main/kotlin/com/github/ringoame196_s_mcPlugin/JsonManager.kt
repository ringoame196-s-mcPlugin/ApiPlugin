package com.github.ringoame196_s_mcPlugin

object JsonManager {
    fun jsonString(data: Map<String, *>): String {
        val sb = StringBuilder("{")

        data.entries.forEachIndexed { index, (key, value) ->
            sb.append("\"").append(key).append("\": \"").append(value).append("\"")
            if (index < data.size - 1) {
                sb.append(", ")
            }
        }

        sb.append("}")
        return sb.toString()
    }
}
