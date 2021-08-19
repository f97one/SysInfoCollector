package net.formula97.androidapps.sysinfocollector.domain.inventory

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "PORTS")
data class Port(
    @PropertyElement(name = "CAPTION", writeAsCData = true)
    var caption: String? = null,
    @PropertyElement(name = "DESCRIPTION", writeAsCData = true)
    var description: String? = null,
    @PropertyElement(name = "NAME", writeAsCData = true)
    var name: String? = null,
    @PropertyElement(name = "TYPE", writeAsCData = true)
    var type: String? = null
): InventoryCategory
