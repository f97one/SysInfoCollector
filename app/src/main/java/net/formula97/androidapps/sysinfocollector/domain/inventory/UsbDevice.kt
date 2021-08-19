package net.formula97.androidapps.sysinfocollector.domain.inventory

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "USBDEVICES")
data class UsbDevice(
    /**
     * device USB vendor ID
     */
    @PropertyElement(name = "VENDORID", writeAsCData = true)
    var vendorId: String? = null,
    /**
     * device USB product ID
     */
    @PropertyElement(name = "PRODUCTID", writeAsCData = true)
    var productId: String? = null,
    /**
     * device manufacturer
     */
    @PropertyElement(name = "MANUFACTURER", writeAsCData = true)
    var manufacturer: String? = null,
    /**
     * device caption
     */
    @PropertyElement(name = "CAPTION", writeAsCData = true)
    var caption: String? = null,
    /**
     * device serial number
     */
    @PropertyElement(name = "SERIAL", writeAsCData = true)
    var serial: String? = null,
    /**
     * device USB class ID
     */
    @PropertyElement(name = "CLASS", writeAsCData = true)
    var usbClassId: String? = null,
    /**
     * device USB subclass ID
     */
    @PropertyElement(name = "SUBCLASS", writeAsCData = true)
    var subSubClass: String? = null,
    /**
     * device name
     */
    @PropertyElement(name = "NAME", writeAsCData = true)
    var name: String = "",
)
