package net.formula97.androidapps.sysinfocollector.domain.inventory

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "ENVS")
data class Env(
    @PropertyElement(name = "KEY", writeAsCData = true)
    var key: String = "",
    @PropertyElement(name = "VAL", writeAsCData = true)
    var value: String? = null
): InventoryCategory
