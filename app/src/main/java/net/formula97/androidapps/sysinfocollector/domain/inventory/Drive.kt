package net.formula97.androidapps.sysinfocollector.domain.inventory

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml
import net.formula97.androidapps.sysinfocollector.logic.converter.BoolToIntConverter
import net.formula97.androidapps.sysinfocollector.logic.converter.StdDateConverter
import java.util.*

/**
 * Filesystem configuration
 */
@Xml(name = "DRIVES")
data class Drive(
    /**
     * creation date
     */
    @PropertyElement(name = "CREATEDATE", writeAsCData = true, converter = StdDateConverter::class)
    var createDate: Date? = null,
    @PropertyElement(name = "DESCRIPTION", writeAsCData = true)
    var description: String = "",
    /**
     * free space, in MB
     */
    @PropertyElement(name = "FREE", writeAsCData = true)
    var free: Double? = null,
    /**
     * total space, in MB
     */
    @PropertyElement(name = "TOTAL", writeAsCData = true)
    var total: Double? = null,
    /**
     * filesystem type, ie 'ext3'
     */
    @PropertyElement(name = "FILESYSTEM", writeAsCData = true)
    var filesystem: String = "",
    /**
     * filesystem user name
     */
    @PropertyElement(name = "LABEL", writeAsCData = true)
    var label: String? = null,
    /**
     * filesystem system name, ie '/dev/sda1' or 'host:/path' for NFS
     */
    @PropertyElement(name = "VOLUME", writeAsCData = true)
    var volume: String = "",
    /**
     * filesystem letter (Windows only)
     */
    @PropertyElement(name = "LETTER", writeAsCData = true)
    var letter: String? = null,
    /**
     * filesystem serial number or UUID
     */
    @PropertyElement(name = "SERIAL")
    var serial: String? = null,
    /**
     * whether it is the system partition (Windows only)
     */
    @PropertyElement(name = "SYSTEMDRIVE", writeAsCData = true, converter = BoolToIntConverter::class)
    var systemDrive: Boolean = false,
    /**
     * filesystem mount point (Unix only)
     */
    @PropertyElement(name = "TYPE", writeAsCData = true)
    var type: String? = null,
    /**
     * supported encryption: BitLocker, cryptsetup, FileVault, ...
     */
    @PropertyElement(name = "ENCRYPT_NAME", writeAsCData = true)
    var encryptName: String? = null,
    /**
     * encryption algorithm: AES_128, AES_256, HARDWARE_ENCRYPTION, ...
     */
    @PropertyElement(name = "ENCRYPT_ALGO", writeAsCData = true)
    var encryptAlgo: String? = null,
    /**
     * encryption status: Yes, No, Partially, ...
     */
    @PropertyElement(name = "ENCRYPT_STATUS", writeAsCData = true)
    var encryptStatus: String? = null,
    /**
     * encryption type: hardware, software, ...
     */
    @PropertyElement(name = "ENCRYPT_TYPE", writeAsCData = true)
    var encryptType: String? = null
) : InventoryCategory
