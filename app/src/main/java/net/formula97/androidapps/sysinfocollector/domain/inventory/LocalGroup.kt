package net.formula97.androidapps.sysinfocollector.domain.inventory

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "LOCAL_GROUPS")
data class LocalGroup(
    @PropertyElement(name = "ID", writeAsCData = true)
    var id: String? = null,
    @PropertyElement(name = "NAME", writeAsCData = true)
    var name: String? = null,
    @Element(name = "MEMBER")
    var member: List<String>? = null
): InventoryCategory
