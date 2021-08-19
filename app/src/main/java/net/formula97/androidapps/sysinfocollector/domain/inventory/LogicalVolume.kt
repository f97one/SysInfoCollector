package net.formula97.androidapps.sysinfocollector.domain.inventory

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml
import net.formula97.androidapps.sysinfocollector.logic.converter.UuidConverter
import java.util.*

/**
 * LVM logical volume
 */
@Xml(name = "LOGICAL_VOLUMES")
data class LogicalVolume(
    /**
     * name of logical volume
     */
    @PropertyElement(name = "LV_NAME", writeAsCData = true)
    var lvName: String? = null,
    /**
     * name of volume group
     */
    @PropertyElement(name = "VG_NAME", writeAsCData = true)
    var vgName: String? = null,
    /**
     * attribute
     */
    @PropertyElement(name = "ATTR", writeAsCData = true)
    var attr: String? = null,
    /**
     * size, in MB
     */
    @PropertyElement(name = "SIZE", writeAsCData = true)
    var size: Long = 0,
    /**
     * UUID
     */
    @PropertyElement(name = "LV_UUID", writeAsCData = true, converter = UuidConverter::class)
    var lvUuid: UUID? = null,
    @PropertyElement(name = "SEG_COUNT", writeAsCData = true)
    var SEG_COUNT: String? = null,
    /**
     * volume group UUID
     */
    @PropertyElement(name = "VG_UUID", writeAsCData = true, converter = UuidConverter::class)
    var vgUuid: UUID? = null
): InventoryCategory
