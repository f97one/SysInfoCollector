package net.formula97.androidapps.sysinfocollector.logic.factory

import net.formula97.androidapps.sysinfocollector.domain.inventory.Memory
import java.io.File

class MemoryFactory: AbstractInventoryBuilder<Memory>() {
    fun from(): Memory {
        return Memory().apply {
            description = "Memory"
            capacity = getTotalMemory()
            type = readMemoryInfo().first
            speed = readMemoryInfo().second.toInt()
        }
    }

    fun getTotalMemory(): Int {
        val memLine = File("/proc/meminfo").readLines().first { it.startsWith("MemTotal") }
        val t = memLine.split(":", ignoreCase = true, limit = 0)[1].trim()
        var multiplier = 1F
        if (t.lowercase().endsWith("kb")) {
            multiplier = 1000F
        } else if (t.lowercase().endsWith("gb")) {
            multiplier = 0.001F
        }
        val mem = t.split(" ", ignoreCase = true, limit = 0)[0]

        return (mem.toFloat() / multiplier).toInt()
    }

    fun readMemoryInfo(): Pair<String, String> {
        val ddrType = readLinesFromFile("/sys/bus/platform/drivers/ddr_type/ddr_type")
        if (ddrType.isEmpty()) {
            val ddrHw = readSystemProperty("ro.boot.hardware.ddr") ?: return Pair(NOT_APPLICABLE, NOT_APPLICABLE)
            if (ddrHw.isNotEmpty()) {
                val i = ddrHw.indexOf("LPDDR")
                if (i > 0) {
                    return asPair(ddrHw)
                }
            }
        } else {
            return asPair(ddrType)
        }

        return Pair(NOT_APPLICABLE, NOT_APPLICABLE)
    }

    private fun asPair(info: String): Pair<String, String> {
        return if (info.contains("_")) {
            val s = info.split("_", limit = 2)
            Pair(s[0], s[1])
        } else {
            Pair(info, NOT_APPLICABLE)
        }
    }
}