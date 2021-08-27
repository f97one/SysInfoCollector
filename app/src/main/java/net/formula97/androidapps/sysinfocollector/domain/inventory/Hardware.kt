package net.formula97.androidapps.sysinfocollector.domain.inventory

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml
import net.formula97.androidapps.sysinfocollector.domain.VirtualizationTechnology
import net.formula97.androidapps.sysinfocollector.logic.converter.HexadecimalUuidConverter
import net.formula97.androidapps.sysinfocollector.logic.converter.StdDateTimeConverter
import net.formula97.androidapps.sysinfocollector.logic.converter.VTConverter
import java.util.*

/**
 * Current Hardware
 */
@Xml(name = "HARDWARE")
data class Hardware(
    /**
     * current user list ('/' as delimiter)
     */
    @Deprecated("")
    @PropertyElement(name = "USERID", writeAsCData = true)
    var userId: String? = null,
    /**
     * operating system version number
     */
    @Deprecated("Use InventoryResult.OperatingSystem#version and InventoryResult.OperatingSystem#kernelVersion instead")
    @PropertyElement(name = "OSVERSION", writeAsCData = true)
    var osVersion: String? = null,
    /**
     * operating system revision number
     *
     * (Service Pack on Windows, kernel build date on Linux)
     */
    @PropertyElement(name = "OSCOMMENTS", writeAsCData = true)
    var osComments: String = "",
    /**
     * operating system full name
     */
    @Deprecated("Use InventoryResult.OperatingSystem#name an InventoryResult.OperatingSystem#fullName instead")
    @PropertyElement(name = "OSNAME", writeAsCData = true)
    var osName: String? = null,
    /**
     * OS checksum
     */
    @Deprecated("no longer supported")
    @PropertyElement(name = "CHECKSUM", writeAsCData = true)
    var checksum: String? = null,
    /**
     * Processor types
     */
    @Deprecated("Use InventoryResult.Cpus instead")
    @PropertyElement(name = "PROCESSORT", writeAsCData = true)
    var processorT: String? = null,
    /**
     * Processor number
     */
    @Deprecated("Use InventoryResult.Cpus instead")
    @PropertyElement(name = "PROCESSORN", writeAsCData = true)
    var processorN: String? = null,
    /**
     * Processor serial
     */
    @Deprecated("Use InventoryResult.Cpus instead")
    @PropertyElement(name = "PROCESSORS", writeAsCData = true)
    var processorS: String? = null,
    /**
     * Hardware name
     */
    @PropertyElement(name = "NAME", writeAsCData = true)
    var name: String = "",
    /**
     * swap memory in MB
     */
    @PropertyElement(name = "SWAP", writeAsCData = true)
    var swap: Int? = null,
    /**
     * Total system memory in MB
     */
    @PropertyElement(name = "MEMORY", writeAsCData = true)
    var memory: Int = 0,
    /**
     * time needed to run the inventory
     */
    @PropertyElement(name = "ETYPE", writeAsCData = true)
    var eTime: String? = null,
    /**
     * Hardware type
     */
    @PropertyElement(name = "TYPE", writeAsCData = true)
    var type: String? = null,
    /**
     * computer chassis format, ie 'Notebook', 'Laptop', 'Server', etc.
     */
    @PropertyElement(name = "CHASSIS_TYPE", writeAsCData = true)
    var chassisType: String = "",
    /**
     * IP address
     */
    @PropertyElement(name = "IPADDR", writeAsCData = true)
    var ipAddr: String = "0.0.0.0",
    /**
     * Workgroup name
     */
    @PropertyElement(name = "WORKGROUP", writeAsCData = true)
    var workgroup: String? = null,
    /**
     * hardware description
     */
    @PropertyElement(name = "DESCRIPTION", writeAsCData = true)
    var description: String? = null,
    /**
     * computer unique identifier
     */
    @PropertyElement(
        name = "UUID",
        writeAsCData = true,
        converter = HexadecimalUuidConverter::class
    )
    var uuid: UUID? = null,
    /**
     * DNS
     */
    @PropertyElement(name = "DNS", writeAsCData = true)
    var dns: String? = null,
    /**
     * last logged user login
     */
    @PropertyElement(name = "LASTLOGGEDUSER", writeAsCData = true)
    var lastLoggedUser: String = "",
    /**
     * User domain
     */
    @Deprecated("Use User instead")
    @PropertyElement(name = "USERDOMAIN", writeAsCData = true)
    var userDomain: String? = null,
    /**
     * date that user last logged
     */
    @PropertyElement(
        name = "DATELASTLOGGEDUSER",
        writeAsCData = true,
        converter = StdDateTimeConverter::class
    )
    var dateLastLoggedUser: Date? = null,
    /**
     * Default gateway
     */
    @PropertyElement(name = "DEFAULTGATEWAY", writeAsCData = true)
    var defaultGateway: String? = null,
    /**
     * virtualization technology
     */
    @PropertyElement(name = "VMSYSTEM", writeAsCData = true, converter = VTConverter::class)
    var vmSystem: VirtualizationTechnology? = null,
    /**
     * virtual machine name the hypervisor (VM only)
     */
    @PropertyElement(name = "VMNAME", writeAsCData = true)
    var vmName: String? = null,
    @PropertyElement(name = "WINOWNER", writeAsCData = true)
    var winOwner: String? = null,
    @PropertyElement(name = "WINPRODID", writeAsCData = true)
    var winProdId: String? = null,
    @PropertyElement(name = "WINPRODKEY", writeAsCData = true)
    var winProdKey: String? = null,
    @PropertyElement(name = "WINCOMPANY", writeAsCData = true)
    var winCompany: String? = null,
    /**
     * Language code (Windows only)
     */
    @PropertyElement(name = "WINLANG", writeAsCData = true)
    var winLang: String? = null,
    @PropertyElement(name = "VMHOSTSERIAL", writeAsCData = true)
    var vmHostSerial: String? = null,
    @PropertyElement(name = "ARCHNAME", writeAsCData = true)
    var archName: String = "",
) : InventoryCategory
