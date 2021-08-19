package net.formula97.androidapps.sysinfocollector.domain.inventory

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml
import net.formula97.androidapps.sysinfocollector.logic.converter.StdDateTimeConverter
import java.util.*

@Xml(name = "PROCESSES")
data class Process(
    /**
     * process owner
     */
    @PropertyElement(name = "USER", writeAsCData = true)
    var user: String? = null,
    /**
     * process ID
     */
    @PropertyElement(name = "PID", writeAsCData = true)
    var pid: Int = -1,
    /**
     * CPU usage
     */
    @PropertyElement(name = "CPUUSAGE", writeAsCData = true)
    var cpuUsage: Double? = null,
    @PropertyElement(name = "MEM", writeAsCData = true)
    var mem: Double? = null,
    @PropertyElement(name = "VIRTUALMEMORY", writeAsCData = true)
    var virtualMemory: Long? = null,
    @PropertyElement(name = "TTY", writeAsCData = true)
    var tty: String? = null,
    /**
     * process start time
     */
    @PropertyElement(name = "STARTED", writeAsCData = true, converter = StdDateTimeConverter::class)
    var started: Date? = null,
    /**
     * process command
     */
    @PropertyElement(name = "CMD", writeAsCData = true)
    var cmd: String? = null
): InventoryCategory
