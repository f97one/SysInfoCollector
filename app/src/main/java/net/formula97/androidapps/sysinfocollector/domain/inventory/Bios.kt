package net.formula97.androidapps.sysinfocollector.domain.inventory

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml
import java.util.*

@Xml(name = "BIOS")
data class Bios(
    /**
     * System model
     */
    @PropertyElement(name = "SMODEL", writeAsCData = true)
    var sModel: String = "",
    /**
     * System manufacturer
     */
    @PropertyElement(name = "SMANUFACTURER", writeAsCData = true)
    var sManufacturer: String = "",
    /**
     * System Serial number
     */
    @PropertyElement(name = "SSN", writeAsCData = true)
    var serialNumber: String = "",
    /**
     * BIOS release date
     */
    @PropertyElement(name = "BDATE", writeAsCData = true)
    var bDate: Date = Date(),
    /**
     * BIOS version
     */
    @PropertyElement(name = "BVERSION", writeAsCData = true)
    var bVersion: String = "",
    /**
     * BIOS manufacturer
     */
    @PropertyElement(name = "BMANUFACTURER", writeAsCData = true)
    var bManufacturer: String = "",
    /**
     * BIOS Serial number
     */
    @PropertyElement(name = "BIOSSERIAL", writeAsCData = true)
    var biosSerial: String = "",
    /**
     * Motherboard manufacturer
     */
    @PropertyElement(name = "MMANUFACTURER", writeAsCData = true)
    var mManufacturer: String = "",
    /**
     * Motherboard Serial number
     */
    @PropertyElement(name = "MSN", writeAsCData = true)
    var msn: String = "",
    /**
     * Motherboard model
     */
    @PropertyElement(name = "MMODEL", writeAsCData = true)
    var mModel: String = "",
    /**
     * Asset tag
     */
    @PropertyElement(name = "ASSETTAG", writeAsCData = true)
    var assetTag: String = "",
    /**
     * Enclosure serial number
     */
    @PropertyElement(name = "ENCLOSURESERIAL", writeAsCData = true)
    var enclosureSerial: String = "",
    /**
     * Legacy chassis type
     */
    @Deprecated("Use InventoryResult.Hardware#chassisType instead")
    @PropertyElement(name = "TYPE", writeAsCData = true)
    var type: String? = null,
    /**
     * SKU number
     */
    @PropertyElement(name = "SKUNUMBER", writeAsCData = true)
    var skuNumber: String = ""
) : InventoryCategory
