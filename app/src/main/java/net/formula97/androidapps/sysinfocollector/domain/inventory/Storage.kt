package net.formula97.androidapps.sysinfocollector.domain.inventory

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml
import net.formula97.androidapps.sysinfocollector.domain.StorageIFType
import net.formula97.androidapps.sysinfocollector.logic.converter.StorageIFConverter

@Xml(name = "STORAGES")
data class Storage(
    /**
     * device name, ie 'hda' on Linux, '\\.\PHYSICALDRIVE0' on Windows
     */
    @PropertyElement(name = "NAME", writeAsCData = true)
    var name: String = "",
    /**
     * device description
     */
    @PropertyElement(name = "DESCRIPTION", writeAsCData = true)
    var description: String? = null,
    /**
     * device size, in MB
     */
    @PropertyElement(name = "DISKSIZE")
    var diskSize: Long = 0L,
    /**
     * device interface type
     */
    @PropertyElement(name = "INTERFACE", writeAsCData = true, converter = StorageIFConverter::class)
    var storageIF: StorageIFType? = null,
    @PropertyElement(name = "MANUFACTURER", writeAsCData = true)
    var manufacturer: String? = null,
    @PropertyElement(name = "MODEL", writeAsCData = true)
    var model: String? = null,
    @PropertyElement(name = "TYPE")
    var type: String? = null,
    /**
     * device serial number
     */
    @PropertyElement(name = "SERIAL", writeAsCData = true)
    var serial: String? = null,
    /**
     * device serial number
     */
    @Deprecated("Use property serial instead")
    @PropertyElement(name = "SERIALNUMBER", writeAsCData = true)
    var serialNumber: String? = null,
    @PropertyElement(name = "FIRMWARE", writeAsCData = true)
    var firmware: String? = null,
    @PropertyElement(name = "SCSI_COID", writeAsCData = true)
    var scsiCoId: String? = null,
    @PropertyElement(name = "SCSI_CHID", writeAsCData = true)
    var scsiChId: String? = null,
    @PropertyElement(name = "SCSI_UNID", writeAsCData = true)
    var scsiUnId: String? = null,
    @PropertyElement(name = "SCSI_LUN", writeAsCData = true)
    var scsiLun: String? = null,
    /**
     * World Wide Name
     *
     * [http://fr.wikipedia.org/wiki/World_Wide_Name]
     */
    @PropertyElement(name = "WWN", writeAsCData = true)
    var wwn: String? = null,
    /**
     * supported encryption name
     */
    @PropertyElement(name = "ENCRYPT_NAME", writeAsCData = true)
    var encryptName: String? = null,
    /**
     * encryption algorithm
     */
    @PropertyElement(name = "ENCRYPT_ALGO", writeAsCData = true)
    var encryptAlgo: String? = null,
    /**
     * encryption status
     */
    @PropertyElement(name = "ENCRYPT_STATUS", writeAsCData = true)
    var encryptStatus: String? = null,
    /**
     * encryption type
     */
    @PropertyElement(name = "ENCRYPT_TYPE", writeAsCData = true)
    var encryptType: String? = null
) : InventoryCategory
