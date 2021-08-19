package net.formula97.androidapps.sysinfocollector.domain.inventory

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml
import net.formula97.androidapps.sysinfocollector.logic.converter.BoolToIntConverter

@Xml(name = "MEMORIES")
data class Memory(
    /**
     * memory capacity, in MB
     */
    @PropertyElement(name = "CAPACITY", writeAsCData = true)
    var capacity: Int? = null,
    @PropertyElement(name = "CAPTION", writeAsCData = true)
    var caption: String? = null,
    /**
     * See Win32_PhysicalMemory documentation
     */
    @PropertyElement(name = "FORMFACTOR", writeAsCData = true)
    var FORM_FACTOR: String? = null,
    @PropertyElement(name = "REMOVABLE", writeAsCData = true, converter = BoolToIntConverter::class)
    var removable: Boolean = false,
    /**
     * See Win32_PhysicalMemory documentation
     */
    @PropertyElement(name = "PURPOSE", writeAsCData = true)
    var purpose: String? = null,
    /**
     * memory frequency, in Mhz
     */
    @PropertyElement(name = "SPEED", writeAsCData = true)
    var speed: Int? = null,
    /**
     * memory serial number
     */
    @PropertyElement(name = "SERIALNUMBER", writeAsCData = true)
    var serialNumber: String? = null,
    /**
     * memory model
     */
    @PropertyElement(name = "MODEL", writeAsCData = true)
    var model: String? = null,
    @PropertyElement(name = "TYPE", writeAsCData = true)
    var type: String? = null,
    @PropertyElement(name = "DESCRIPTION", writeAsCData = true)
    var description: String? = null,
    @PropertyElement(name = "NUMSLOTS", writeAsCData = true)
    var NUM_SLOTS: Int? = null,
    @PropertyElement(name = "MEMORYCORRECTION", writeAsCData = true)
    var memoryCorrection: String? = null,
    @PropertyElement(name = "MANUFACTURER", writeAsCData = true)
    var manufacturer: String? = null
): InventoryCategory
