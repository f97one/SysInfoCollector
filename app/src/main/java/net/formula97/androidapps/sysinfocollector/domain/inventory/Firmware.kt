package net.formula97.androidapps.sysinfocollector.domain.inventory

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml
import net.formula97.androidapps.sysinfocollector.logic.converter.StdDateConverter
import java.util.*

/**
 * firmware component
 */
@Xml(name = "FIRMWARES")
data class Firmware(
    /**
     * component name using the firmware
     */
    @PropertyElement(name = "NAME", writeAsCData = true)
    var name: String = "",
    /**
     * firmware description if available
     */
    @PropertyElement(name = "DESCRIPTION", writeAsCData = true)
    var description: String? = null,
    /**
     * short description of firmware type: modem, bios, ...
     */
    @PropertyElement(name = "TYPE", writeAsCData = true)
    var type: String? = null,
    /**
     * full firmware version
     */
    @PropertyElement(name = "VERSION", writeAsCData = true)
    var version: String? = null,
    /**
     * firmware date
     */
    @PropertyElement(name = "DATE", writeAsCData = true, converter = StdDateConverter::class)
    var date: Date? = null,
    /**
     * firmware manufacturer
     */
    @PropertyElement(name = "MANUFACTURER", writeAsCData = true)
    var manufacturer: String? = null
): InventoryCategory
