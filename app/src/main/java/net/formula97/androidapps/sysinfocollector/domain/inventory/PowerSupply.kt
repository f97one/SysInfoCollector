package net.formula97.androidapps.sysinfocollector.domain.inventory

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml
import net.formula97.androidapps.sysinfocollector.logic.converter.YesNoConverter

@Xml(name = "POWERSUPPLIES")
data class PowerSupply(
    /**
     * powersupply name
     */
    @PropertyElement(name = "NAME", writeAsCData = true)
    var name: String = "",
    /**
     * powersupply max power in Watt
     */
    @PropertyElement(name = "POWER_MAX", writeAsCData = true)
    var powerMax: Int? = null,
    /**
     * powersupply serial number
     */
    @PropertyElement(name = "SERIALNUMBER", writeAsCData = true)
    var serialNumber: String? = null,
    /**
     * powersupply manufacturer
     */
    @PropertyElement(name = "MANUFACTURER", writeAsCData = true)
    var manufacturer: String? = null,
    /**
     * powersupply Part Number
     */
    @PropertyElement(name = "PARTNUM", writeAsCData = true)
    var partNum: String? = null,
    /**
     * powersupply model
     */
    @PropertyElement(name = "MODEL", writeAsCData = true)
    var model: String? = null,
    /**
     * powersupply hotreplaceable feature (Yes|No)
     */
    @PropertyElement(name = "HOTREPLACEABLE", writeAsCData = true, converter = YesNoConverter::class)
    var hotReplaceable: Boolean = false,
    /**
     * powersupply plugged status (Yes|No)
     */
    @PropertyElement(name = "PLUGGED", writeAsCData = true, converter = YesNoConverter::class)
    var plugged: Boolean = false,
    /**
     * powersupply status
     */
    @PropertyElement(name = "STATUS", writeAsCData = true)
    var status: String? = null,
    /**
     * powersupply location in computer
     */
    @PropertyElement(name = "LOCATION", writeAsCData = true)
    var location: String? = null,
)
