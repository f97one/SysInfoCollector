package net.formula97.androidapps.sysinfocollector.logic.factory

import android.content.Context
import android.os.Build
import android.provider.Settings
import net.formula97.androidapps.sysinfocollector.domain.inventory.Hardware
import timber.log.Timber
import java.io.BufferedReader
import java.io.ByteArrayInputStream
import java.io.DataOutputStream
import java.io.InputStreamReader
import java.lang.reflect.InvocationTargetException
import java.text.SimpleDateFormat
import java.util.*
import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory

class HardwareFactory: AbstractInventoryBuilder<Hardware>(), ContextInventoryInjector<Hardware> {
    override fun fromContext(context: Context): Hardware {
        return Hardware().apply {
            osComments = readLinesFromFile("/proc/version")
            name = getHardwareName(context)
            memory = MemoryFactory().getTotalMemory()
            chassisType = "Smartphone"
            archName = System.getProperty("os.arch") ?: NOT_APPLICABLE
            uuid = getUUID(context)
            lastLoggedUser = getLastLoggedUser()!!
            dateLastLoggedUser = getLastLoggedDate()
        }
    }

    override fun listFromContext(context: Context): MutableList<Hardware> = mutableListOf(fromContext(context))

    private fun getHardwareName(context: Context): String {
        var ret = readSystemProperty("net.hostname")
        if (ret == null || ret == Build.UNKNOWN) {
            try {// try to read hardware name by reflection
                val m = Build::class.java.getDeclaredMethod("getString", String::class.java)
                m.isAccessible = true
                ret = m.invoke(null, "net.hostname")?.toString() ?: NOT_APPLICABLE
            } catch (e: Exception) {
                // Kotlin does not have multi-catch like Java
                Timber.e(e)
                ret = NOT_APPLICABLE
            }
        }

        if (ret == NOT_APPLICABLE) {
            val androidId = getSecureAndroidId(context)
            ret = (if (androidId != null) "android-$androidId" else Build.MODEL)
        }

        return ret ?: NOT_APPLICABLE
    }

    private fun getSecureAndroidId(context: Context): String? {
        return Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
    }

    private fun getUUID(context: Context): UUID? {
        val id = getSecureAndroidId(context) ?: return null
        return UUID.fromString(id)
    }

    private fun getSystemUserNames(): List<String> {
        // todo su 以下の処理を汎用化するべくリファクタリングする

        val p = Runtime.getRuntime().exec("su")
        DataOutputStream(p.outputStream).use {
            it.writeBytes("cat /data/system/users/0.xml\n")
            it.writeBytes("exit\n")
            it.flush()
        }
        p.waitFor()

        val ret = mutableListOf<String>()
        val br = p.inputStream.bufferedReader()
        br.useLines {
            it.map { l -> ret.add(l) }
        }
        return ret
    }

    private fun getLastLoggedUser(): String? {
        val users = getSystemUserNames()

        return if (users.size > 2) {
            val docBuilder: DocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder()
            val info = users[2].trim()
            val parsed = docBuilder.parse(ByteArrayInputStream(info.toByteArray()))

            parsed.firstChild.textContent
        } else {
            NOT_APPLICABLE
        }

    }

    private fun getLastLoggedDate(): Date? {
        val users = getSystemUserNames()
        val s = getUserTagValue(users, "lastLoggedIn")
        return if (s != NOT_APPLICABLE) Date(s.toLong()) else null
    }

    private fun getUserTagValue(users: List<String>, tagName: String): String {
        var eval: String = ""
        if (users.size > 1) {
            val removed = users[1].replace("[\"><]", "")
            if (removed.contains("user ")) {
                eval = removed.replace(" ", ",").trim()
            }
            val split = eval.split(",", ignoreCase = true, limit = 0)
            val results = mutableMapOf<String, String>()
            split.forEach {
                if (it.contains("=")) {
                    val kv = it.split("=", limit = 2)
                    results[kv[0]] = kv[1]
                }
            }

            return results[tagName] ?: NOT_APPLICABLE
        } else {
            return NOT_APPLICABLE
        }
    }
}