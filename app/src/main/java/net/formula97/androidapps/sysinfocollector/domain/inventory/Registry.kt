package net.formula97.androidapps.sysinfocollector.domain.inventory

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "REGISTRY")
data class Registry(
    @PropertyElement(name = "NAME", writeAsCData = true)
    var name: String? = null,
    @PropertyElement(name = "REGVALUE", writeAsCData = true)
    var regValue: String? = null,
    @PropertyElement(name = "HIVE", writeAsCData = true)
    var hive: String? = null
): InventoryCategory
