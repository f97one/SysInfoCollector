package net.formula97.androidapps.sysinfocollector.domain.inventory

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml
import net.formula97.androidapps.sysinfocollector.domain.CpuArch
import net.formula97.androidapps.sysinfocollector.logic.converter.CpuArchConverter

@Xml(name = "CPUS")
data class Cpu(
    /**
     * total CPU cache size, in KB
     */
    @PropertyElement(name = "CACHE", writeAsCData = true)
    var cache: Int? = null,
    /**
     * number of cores
     */
    @PropertyElement(name = "CORE", writeAsCData = true)
    var core: Int = 1,
    /**
     * total available cores, as CORE only reports enabled count
     */
    @PropertyElement(name = "CORECOUNT", writeAsCData = true)
    var coreCount: Int? = null,
    @PropertyElement(name = "DESCRIPTION", writeAsCData = true)
    var description: String? = null,
    /**
     * CPU manufacturer, ie 'Intel', 'AMD', etc.
     */
    @PropertyElement(name = "MANUFACTURER", writeAsCData = true)
    var manufacturer: String? = null,
    /**
     * CPU name, ie 'Intel(R) Core(TM)2 Duo CPU P8600  @ 2.40GHz'
     */
    @PropertyElement(name = "NAME", writeAsCData = true)
    var name: String = "",
    /**
     * number of threads per core
     */
    @PropertyElement(name = "THREAD", writeAsCData = true)
    var thread: Int? = null,
    /**
     * CPU serial number
     */
    @PropertyElement(name = "SERIAL", writeAsCData = true)
    var serial: String? = null,
    /**
     * stepping value
     */
    @PropertyElement(name = "STEPPING", writeAsCData = true)
    var stepping: String? = null,
    /**
     * family name
     */
    @PropertyElement(name = "FAMILYNAME", writeAsCData = true)
    var familyName: String? = null,
    /**
     * family value
     */
    @PropertyElement(name = "FAMILYNUMBER", writeAsCData = true)
    var familyNumber: String? = null,
    /**
     * model value
     */
    @PropertyElement(name = "MODEL", writeAsCData = true)
    var model: String? = null,
    /**
     * CPU frequency, in MHz
     */
    @PropertyElement(name = "SPEED", writeAsCData = true)
    var speed: Int? = null,
    @PropertyElement(name = "ID", writeAsCData = true)
    var id: String? = null,
    /**
     * CPU Architecture
     */
    @PropertyElement(name = "ARCH", writeAsCData = true, converter = CpuArchConverter::class)
    var arch: CpuArch = CpuArch.ARM
) : InventoryCategory
