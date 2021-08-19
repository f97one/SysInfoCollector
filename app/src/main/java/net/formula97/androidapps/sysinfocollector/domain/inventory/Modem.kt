package net.formula97.androidapps.sysinfocollector.domain.inventory

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

/**
 * current MODEM conditions
 *
 * typically Android devices have no modem.
 */
@Xml(name = "MODEMS")
data class Modem(
    /**
     * modem name
     */
    @PropertyElement(name = "NAME", writeAsCData = true)
    var name: String = "",
    /**
     * modem description if available
     */
    @PropertyElement(name = "DESCRIPTION", writeAsCData = true)
    var description: String? = null,
    /**
     * modem type
     */
    @PropertyElement(name = "TYPE", writeAsCData = true)
    var type: String? = null,
    /**
     * modem model
     */
    @PropertyElement(name = "MODEL", writeAsCData = true)
    var model: String? = null,
    /**
     * modem manufacturer
     */
    @PropertyElement(name = "MANUFACTURER", writeAsCData = true)
    var manufacturer: String? = null,
    /**
     * modem serial
     */
    @PropertyElement(name = "SERIAL", writeAsCData = true)
    var serial: String? = null,
    /**
     * IMEI information
     */
    @PropertyElement(name = "IMEI", writeAsCData = true)
    var imei: String? = null
): InventoryCategory
