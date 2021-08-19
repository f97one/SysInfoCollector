package net.formula97.androidapps.sysinfocollector.domain.inventory

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

/**
 * a physical connection points including ports, motherboard slots and peripherals, and proprietary connection points
 */
@Xml(name = "SLOTS")
data class Slot(
    /**
     * bus type
     */
    @PropertyElement(name = "DESCRIPTION", writeAsCData = true)
    var description: String? = null,
    @PropertyElement(name = "DESIGNATION", writeAsCData = true)
    var designation: String? = null,
    /**
     * slot identifier
     */
    @PropertyElement(name = "NAME", writeAsCData = true)
    var name: String = "",
    /**
     * slot usage status
     */
    @PropertyElement(name = "STATUS", writeAsCData = true)
    var status: String? = null,
): InventoryCategory
