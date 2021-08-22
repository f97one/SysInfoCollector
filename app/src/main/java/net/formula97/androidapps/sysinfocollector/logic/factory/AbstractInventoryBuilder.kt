package net.formula97.androidapps.sysinfocollector.logic.factory

import android.content.Context
import net.formula97.androidapps.sysinfocollector.R
import net.formula97.androidapps.sysinfocollector.domain.CpuFamily
import java.io.File
import java.nio.charset.Charset
import java.nio.charset.StandardCharsets

abstract class AbstractInventoryBuilder<T> {

    companion object {
        const val NOT_APPLICABLE:String = "N/A"
    }

    fun throwIfNotHasFeature(context: Context, feature: String) {
        if (!context.packageManager.hasSystemFeature(feature)) {
            throw IllegalStateException("This device has no feature: $feature")
        }
    }

    fun loadCameraVendors(context: Context): Map<String, String> {
        return loadAsMap(context, R.array.camera_vendors)
    }

    fun loadCpuManufacturer(context: Context): Map<String, String> {
        return loadAsMap(context, R.array.cpu_manufacturer)
    }

    private fun loadAsMap(context: Context, resId: Int): Map<String, String> {
        val resArr = context.resources.getStringArray(resId)
        val map = mutableMapOf<String, String>()
        resArr.forEach { s ->
            val i = s.split("|")
            map[i[0]] = i[1]
        }

        return map
    }

    fun loadCpuFamilies(context: Context): List<CpuFamily> {
        val familyArr = context.resources.getStringArray(R.array.cpu_family)
        val ret = mutableListOf<CpuFamily>()
        familyArr.forEach {
            val s = it.split("|")
            ret.add(CpuFamily(s[0].substring(2).toInt(radix = 16), s[1].substring(2).toInt(radix = 16), s[2]))
        }

        return ret
    }

    fun readLinesFromFile(path: String, charset: Charset = StandardCharsets.UTF_8): String {
        return File(path).readText(charset)
    }
}