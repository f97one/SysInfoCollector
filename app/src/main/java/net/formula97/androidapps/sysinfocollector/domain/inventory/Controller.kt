package net.formula97.androidapps.sysinfocollector.domain.inventory

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "CONTROLLERS")
data class Controller(
    @PropertyElement(name = "DRIVER", writeAsCData = true)
    var driver: String? = null,
    /**
     * device name
     */
    @PropertyElement(name = "NAME", writeAsCData = true)
    var name: String = "",
    /**
     * device caption
     */
    @PropertyElement(name = "CAPTION", writeAsCData = true)
    var caption: String = "",
    /**
     * manufacturer name
     */
    @PropertyElement(name = "MANUFACTURER", writeAsCData = true)
    var manufacturer: String? = null,
    /**
     * device model
     */
    @PropertyElement(name = "MODEL", writeAsCData = true)
    var model: String? = null,
    /**
     * device serial number
     */
    @PropertyElement(name = "SERIAL", writeAsCData = true)
    var serial: String? = null,
    /**
     * device PCI class ID
     */
    @PropertyElement(name = "PCICLASS", writeAsCData = true)
    var pciClass: String? = null,
    /**
     * device PCI vendor ID
     */
    @PropertyElement(name = "VENDORID", writeAsCData = true)
    var vendorId: String? = null,
    /**
     * device PCI product ID
     */
    @PropertyElement(name = "PRODUCTID", writeAsCData = true)
    var productId: String? = null,
    /**
     * device PCI subsystem ID, ie '8086:2a40'
     */
    @PropertyElement(name = "PCISUBSYSTEMID", writeAsCData = true)
    var pciSubsystemId: String? = null,
    /**
     * device PCI slot, ie '00:02.1'
     */
    @PropertyElement(name = "PCISLOT", writeAsCData = true)
    var pciSlot: String? = null,
    @PropertyElement(name = "TYPE", writeAsCData = true)
    var type: String? = null,
    /**
     * controller revision, ie 'rev 02'
     */
    @PropertyElement(name = "REV", writeAsCData = true)
    var rev: String? = null
) : InventoryCategory
