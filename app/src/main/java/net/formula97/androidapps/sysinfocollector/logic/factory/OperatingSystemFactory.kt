package net.formula97.androidapps.sysinfocollector.logic.factory

import android.content.Context
import android.os.Build
import android.os.SystemClock
import net.formula97.androidapps.sysinfocollector.domain.inventory.OperatingSystem
import timber.log.Timber
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*
import kotlin.NoSuchElementException

class OperatingSystemFactory: AbstractInventoryBuilder<OperatingSystem>(), ContextInventoryInjector<OperatingSystem> {
    override fun fromContext(context: Context): OperatingSystem {
        val sysProps = readDeviceProps()
        val architecture = try {
            if (sysProps.first { it.first == "ro.product.cpu.abilist" }.second.isEmpty()) {
                sysProps.first { it.first == "ro.product.cpu.abilist64" }.second
            } else {
                sysProps.first { it.first == "ro.product.cpu.abilist" }.second
            }
        } catch (e: NoSuchElementException) {
            NOT_APPLICABLE
        }

        val sysHostId = try {
            sysProps.first { it.first == "net.hostname" }.second
        } catch (e: NoSuchElementException) {
            NOT_APPLICABLE
        }

        return OperatingSystem().apply {
            arch = architecture.trim()
            name = "Android"
            hostId = sysHostId
            bootTime = Date(System.currentTimeMillis() - SystemClock.elapsedRealtime())
            kernelName = "linux"
            kernelVersion = readKernelVersion()
            fullName = getAndroidName(context)
            version = Build.VERSION.SDK_INT.toString()
            sshKey = NOT_APPLICABLE
            timezone = makeTimezone()
        }
    }

    override fun listFromContext(context: Context): MutableList<OperatingSystem> {
        return mutableListOf(fromContext(context))
    }

    private fun readKernelVersion(): String {
        val p = Runtime.getRuntime().exec("uname -a")
        try {
            if (p.waitFor() == 0) {
                p.inputStream.use { inStream ->
                    BufferedReader(InputStreamReader(inStream), 64).use { return it.readLine() }
                }
            }
        } catch (e: IOException) {
            Timber.e(e)
        }

        return NOT_APPLICABLE
    }

    private fun getAndroidName(context: Context): String {
        var osName = "#NAME($NOT_APPLICABLE)"
        var versionName = ""
        try {
            val androidVer = loadAndroidVersions(context).first { it.apiLevel == Build.VERSION.SDK_INT }
            osName = androidVer.codename
            versionName = androidVer.versionName
        } catch (e: NoSuchElementException) {
            Timber.e(e)
        }
        return "$osName $versionName API ${Build.VERSION.SDK_INT}"
    }

    private fun makeTimezone(): OperatingSystem.InventoryTimeZone {
        val tz = TimeZone.getDefault()

        return OperatingSystem.InventoryTimeZone(name = tz.id, offset = tz.getDisplayName(false, TimeZone.SHORT))
    }
}