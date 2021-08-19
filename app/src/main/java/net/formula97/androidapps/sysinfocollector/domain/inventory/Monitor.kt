package net.formula97.androidapps.sysinfocollector.domain.inventory

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "MONITORS")
data class Monitor(
    // todo uuencodeではなくbase64として評価するconverterを書く
    /**
     * base64-encoded EDID frame
     */
    @PropertyElement(name = "BASE64", writeAsCData = true)
    var base64: String = "",
    @PropertyElement(name = "CAPTION", writeAsCData = true)
    var caption: String? = null,
    @PropertyElement(name = "DESCRIPTION", writeAsCData = true)
    var description: String? = null,
    /**
     * monitor manufacturer
     */
    @PropertyElement(name = "MANUFACTURER", writeAsCData = true)
    var manufacturer: String? = null,
    /**
     * monitor serial number
     */
    @PropertyElement(name = "SERIAL", writeAsCData = true)
    var serial: String? = null,
    /**
     * alternative monitor serial number computed from known manufacturer formula and if different from SERIAL
     */
    @PropertyElement(name = "ALTSERIAL", writeAsCData = true)
    var altSerial: String? = null,
    /**
     * Used port to connect the device
     */
    @PropertyElement(name = "PORT", writeAsCData = true)
    var port: String? = null,
    /**
     * uuencoded EDID frame
     */
    @PropertyElement(name = "UUENCODE", writeAsCData = true)
    var uuencode: String? = null,
    @PropertyElement(name = "NAME", writeAsCData = true)
    var name: String? = null,
    @PropertyElement(name = "TYPE", writeAsCData = true)
    var type: String? = null
): InventoryCategory
