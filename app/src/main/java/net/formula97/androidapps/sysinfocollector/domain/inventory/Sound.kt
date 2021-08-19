package net.formula97.androidapps.sysinfocollector.domain.inventory

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

/**
 * Sound device condition
 */
@Xml(name = "SOUNDS")
data class Sound(
    @PropertyElement(name = "CAPTION", writeAsCData = true)
    var caption: String? = null,
    @PropertyElement(name = "DESCRIPTION", writeAsCData = true)
    var description: String? = null,
    @PropertyElement(name = "MANUFACTURER", writeAsCData = true)
    var manufacturer: String? = null,
    @PropertyElement(name = "NAME", writeAsCData = true)
    var name: String? = null
): InventoryCategory
