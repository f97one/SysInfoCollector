package net.formula97.androidapps.sysinfocollector.domain.inventory

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

/**
 * Firewall configuration
 */
@Xml(name = "FIREWALL")
data class Firewall(
    /**
     * active connection's interface (Windows only)
     */
    @PropertyElement(name = "DESCRIPTION", writeAsCData = true)
    var description: String? = null,
    /**
     * active connection's ip (Windows only)
     */
    @PropertyElement(name = "IPADDRESS", writeAsCData = true)
    var ipAddress: String? = null,
    /**
     * active connection's ip v6 (Windows only)
     */
    @PropertyElement(name = "IPADDRESS6", writeAsCData = true)
    var ipAddress6: String? = null,
    /**
     * firewall profile (Windows only)
     */
    @PropertyElement(name = "PROFILE", writeAsCData = true)
    var profile: String? = null,
    /**
     * firewall status
     */
    @PropertyElement(name = "STATUS", writeAsCData = true)
    var status: String = ""
) : InventoryCategory
