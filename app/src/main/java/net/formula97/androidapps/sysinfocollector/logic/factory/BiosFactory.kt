package net.formula97.androidapps.sysinfocollector.logic.factory

import android.content.Context
import android.os.Build
import net.formula97.androidapps.sysinfocollector.domain.inventory.Bios
import timber.log.Timber
import java.io.File
import java.util.*

class BiosFactory: AbstractInventoryBuilder<Bios>(), ContextInventoryInjector<Bios> {
    override fun fromContext(context: Context): Bios {

        return Bios().apply {
            sModel = Build.MODEL
            sManufacturer = Build.MANUFACTURER
            serialNumber = findSystemSerial()
            bDate = getBiosDate(context)
            bManufacturer = Build.MANUFACTURER
            mManufacturer = Build.MANUFACTURER
            biosSerial = NOT_APPLICABLE
            bVersion = readLinesFromFile("/sys/devices/virtual/dmi/id/bios_version")
            msn = readLinesFromFile("/sys/devices/virtual/dmi/id/board_serial")
            mModel = Build.MODEL
            assetTag = Build.TAGS
            enclosureSerial = NOT_APPLICABLE
            skuNumber = NOT_APPLICABLE
        }
    }

    override fun listFromContext(context: Context): MutableList<Bios> {
        return mutableListOf(fromContext(context))
    }

    /**
     * Try to read system serial from procfs.
     *
     * @return System Serial number derived from /proc/cpuinfo, if not available, returns just "N/A"
     */
    private fun findSystemSerial(): String {
        // android.os.Build.getSerial() requires protected permissions,
        // so try to get them from /proc/cpuinfo
        val cpuInfo = File("/proc/cpuinfo").readLines()
        val serialLines = cpuInfo.filter { it.startsWith("Serial") }

        if (serialLines.isEmpty()) {
            return NOT_APPLICABLE
        }

        return serialLines[0].split(":", ignoreCase = true, limit = 0)[1].trim()
    }

    private fun getBiosDate(context: Context): Date? {
        val sysDateFormat = android.text.format.DateFormat.getDateFormat(context.applicationContext)

        val biosDateLine = readLinesFromFile("/sys/devices/virtual/dmi/id/bios_date")

        return try {
            sysDateFormat.parse(biosDateLine)
        } catch (e: Exception) {
            Timber.w(e)
            null
        }
    }
}