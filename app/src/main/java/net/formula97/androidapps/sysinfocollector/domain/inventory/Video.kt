package net.formula97.androidapps.sysinfocollector.domain.inventory

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "VIDEOS")
data class Video(
    @PropertyElement(name = "CHIPSET", writeAsCData = true)
    var chipSet: String? = null,
    /**
     * video card memory, in MB
     */
    @PropertyElement(name = "MEMORY", writeAsCData = true)
    var memory: Int? = null,
    @PropertyElement(name = "NAME", writeAsCData = true)
    var name: String = "",
    /**
     * video card resolution, ie '1024x768'
     */
    @PropertyElement(name = "RESOLUTION", writeAsCData = true)
    var resolution: String? = null,
    /**
     * video card PCI slot ID
     */
    @PropertyElement(name = "PCISLOT", writeAsCData = true)
    var pciSlot: String? = null
)
