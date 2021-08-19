package net.formula97.androidapps.sysinfocollector.domain.inventory

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "STORAGES")
data class Storage(
    @Element(name = "DESCRIPTION")
    var description: String = "",
    @PropertyElement(name = "DISKSIZE")
    var diskSize: Long = 0L,
    @Element(name = "NAME")
    var name: String = "",
    @Element(name = "TYPE")
    var type: String = "",
) : InventoryCategory
