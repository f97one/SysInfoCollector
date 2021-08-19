package net.formula97.androidapps.sysinfocollector.domain.inventory

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

/**
 * a network configuration, ie a combination of an interface and an IP address
 */
@Xml(name = "NETWORKS")
data class Network(
    /**
     * interface name, ie 'eth0' on Linux, 'AMD PCNET Family Ethernet Adapter' on Windows
     */
    @PropertyElement(name = "DESCRIPTION", writeAsCData = true)
    var description: String? = null,
)
