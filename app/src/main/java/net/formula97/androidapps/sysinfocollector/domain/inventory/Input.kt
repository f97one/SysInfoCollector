package net.formula97.androidapps.sysinfocollector.domain.inventory

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "INPUTS")
data class Input(
    @PropertyElement(name = "NAME", writeAsCData = true)
    var name: String = "",
    @PropertyElement(name = "MANUFACTURER", writeAsCData = true)
    var manufacturer: String? = null,
    @PropertyElement(name = "CAPTION", writeAsCData = true)
    var caption: String? = null,
    @PropertyElement(name = "DESCRIPTION", writeAsCData = true)
    var description: String? = null,
    @PropertyElement(name = "INTERFACE", writeAsCData = true)
    var inputInterface: String? = null,
    @PropertyElement(name = "LAYOUT", writeAsCData = true)
    var layout: String? = null,
    @PropertyElement(name = "POINTINGTYPE", writeAsCData = true)
    var pointingType: Int? = null,
    @PropertyElement(name = "TYPE", writeAsCData = true)
    var type: String? = null
): InventoryCategory
