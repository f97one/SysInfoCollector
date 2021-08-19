package net.formula97.androidapps.sysinfocollector.domain.inventory

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml
import net.formula97.androidapps.sysinfocollector.logic.converter.UuidConverter
import java.util.*

/**
 * a LVM physical volume
 */
@Xml(name = "PHYSICAL_VOLUMES")
data class PhysicalVolume(
    /**
     * UUID
     */
    @PropertyElement(name = "PV_UUID", writeAsCData = true, converter = UuidConverter::class)
    var pvUuid: UUID? = null,
    /**
     * device name, ie '/dev/sda1'
     */
    @PropertyElement(name = "DEVICE", writeAsCData = true)
    var device: String? = null,
    @PropertyElement(name = "PV_PE_COUNT", writeAsCData = true)
    var pvPeCount: String?= null,
    /**
     * format, ie 'lvm2'
     */
    @PropertyElement(name = "FORMAT", writeAsCData = true)
    var format: String? = null,
    /**
     * attributes
     */
    @PropertyElement(name = "ATTR")
    var attr: String? = null,
    /**
     * size of physical volume, in MB
     */
    @PropertyElement(name = "SIZE", writeAsCData = true)
    var size: Double? = null,
    @PropertyElement(name = "FREE", writeAsCData = true)
    var free: Double? = null,
    @PropertyElement(name = "PE_SIZE", writeAsCData = true)
    var peSize: Double? = null,
    @PropertyElement(name = "VG_UUID", writeAsCData = true)
    var vgUuid: UUID? = null
): InventoryCategory
