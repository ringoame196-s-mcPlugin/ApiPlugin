package com.github.ringoame196_s_mcPlugin.api

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

    fun jsonString(dataList: List<Map<String, Any?>>): String {
        val sb = StringBuilder("[")

        dataList.forEachIndexed { i, data ->
            sb.append("{")
            data.entries.forEachIndexed { j, (key, value) ->
                sb.append("\"$key\": \"$value\"")
                if (j < data.size - 1) sb.append(", ")
            }
            sb.append("}")
            if (i < dataList.size - 1) sb.append(", ")
        }

        sb.append("]")
        return sb.toString()
    }
}
