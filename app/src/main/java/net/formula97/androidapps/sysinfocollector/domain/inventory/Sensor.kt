package net.formula97.androidapps.sysinfocollector.domain.inventory

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "SENSORS")
data class Sensor(
    /**
     * name
     */
    @PropertyElement(name = "NAME", writeAsCData = true)
    var name: String = "",
    /**
     * Manufacturer
     */
    @PropertyElement(name = "MANUFACTURER", writeAsCData = true)
    var manufacturer: String? = null,
    /**
     * Version
     */
    @PropertyElement(name = "VERSION", writeAsCData = true)
    var version: String? = null,
    /**
     * Type
     */
    @PropertyElement(name = "TYPE", writeAsCData = true)
    var type: String? = null,
)
