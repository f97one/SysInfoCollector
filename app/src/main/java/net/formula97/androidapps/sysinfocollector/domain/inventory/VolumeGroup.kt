package net.formula97.androidapps.sysinfocollector.domain.inventory

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml
import net.formula97.androidapps.sysinfocollector.logic.converter.UuidConverter
import java.util.*

@Xml(name = "VOLUME_GROUPS")
data class VolumeGroup(
    /**
     * name
     */
    @PropertyElement(name = "VG_NAME", writeAsCData = true)
    var vgName: String? = null,
    /**
     * UUID
     */
    @PropertyElement(name = "VG_UUID", writeAsCData = true, converter = UuidConverter:: class)
    var vgUuid: UUID? = null,
    @PropertyElement(name = "PV_COUNT", writeAsCData = true)
    var pvCount: Int? = null,
    @PropertyElement(name = "LV_COUNT", writeAsCData = true)
    var lvCount: Int? = null,
    /**
     * attributes
     */
    @PropertyElement(name = "ATTR", writeAsCData = true)
    var attr: String? = null,
    /**
     * size, in MB
     */
    @PropertyElement(name = "SIZE", writeAsCData = true)
    var size: Double? = null,
    /**
     * free space
     */
    @PropertyElement(name = "FREE", writeAsCData = true)
    var free: Double? = null,
    @PropertyElement(name = "VG_EXTENT_SIZE", writeAsCData = true)
    var vgExtentSize: Long? = null,
)
