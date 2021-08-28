package net.formula97.androidapps.sysinfocollector.logic.factory

import android.content.Context
import net.formula97.androidapps.sysinfocollector.R
import net.formula97.androidapps.sysinfocollector.domain.AndroidVersion
import net.formula97.androidapps.sysinfocollector.domain.CpuFamily
import timber.log.Timber
import java.io.*
import java.nio.charset.Charset
import java.nio.charset.StandardCharsets
import java.util.*

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

    fun readDeviceProps(): List<Pair<String, String>> {
        val proc = Runtime.getRuntime().exec("getprop")

        val ret = mutableListOf<Pair<String, String>>()
        try {
            BufferedReader(InputStreamReader(proc.inputStream)).use {
                it.readLines().forEach { l ->
                    val tokens = l.split(":", ignoreCase = true, limit = 0)
                    if (tokens.size > 2) {
                        ret.add(Pair(removeBracket(tokens[0]).trim(), removeBracket(tokens[1]).trim()))
                    }
                }
            }
        } catch (e: IOException) {
            Timber.e(e)
        }

        return ret
    }

    fun readSystemProperty(propName: String): String? {
        return try {
            readDeviceProps().filter { it.first == propName }.map { it.second }.first()
        } catch (e: Exception) {
            null
        }
    }

    private fun removeBracket(token: String): String {
        return token.replace("\\[", "").replace("]", "")
    }

    fun loadAndroidVersions(context: Context): List<AndroidVersion> {
        val versionsArray = context.resources.getStringArray(R.array.android_version_names)

        val ret = mutableListOf<AndroidVersion>()
        versionsArray.forEach {
            val t = it.split("|", limit = 0)
            ret.add(AndroidVersion(t[0].toInt(), t[1], t[2]))
        }

        return ret
    }
}