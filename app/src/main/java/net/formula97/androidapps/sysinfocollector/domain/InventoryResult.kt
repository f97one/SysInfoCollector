package net.formula97.androidapps.sysinfocollector.domain

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml
import net.formula97.androidapps.sysinfocollector.logic.converter.*
import java.util.*

@Xml(name = "REQUEST")
data class InventoryResult(
    /**
     * message type, ie "SNMPQUERY"
     */
    @PropertyElement(name = "QUERY", writeAsCData = true)
    var query: String = "INVENTORY",
    /**
     * Agent ID
     */
    @PropertyElement(name = "DEVICEID", writeAsCData = true)
    var deviceId: String = "",
    /**
     * Inventory Content
     */
    @Element(name = "CONTENT")
    var content: Content = Content()
) {
    /**
     * Inventory Content Body
     */
    @Xml(name = "CONTENT")
    data class Content(
        @PropertyElement(name = "VERSIONCLIENT", writeAsCData = true)
        var versionClient: String = "",
        @Element
        var bios: Bios? = null,
        @Element
        var accountInfo: AccountInfo = AccountInfo(),
        @Element
        var accessLog: AccessLog = AccessLog(),
        @Element
        var hardware: Hardware = Hardware(),
        @Element
        var operatingSystem: OperatingSystem = OperatingSystem(),
        @Element
        var antivirus: List<Antivirus> = listOf(),
        @Element
        var batteries: List<Battery> = listOf(),
        @Element
        var controllers: List<Controller> = listOf(),
        @Element
        var cpus: List<Cpu> = listOf(),
        @Element
        var drives: List<Drive> = listOf(),
        @Element
        var envs: List<Env> = listOf(),
        @Element
        var firewall: Firewall? = null,
        @Element
        var inputs: List<Input> = listOf(),
        @Element
        var storages: List<Storage> = listOf()
    ) {}

    /**
     * System BIOS information.
     */
    @Xml(name = "BIOS")
    data class Bios(
        /**
         * System model
         */
        @PropertyElement(name = "SMODEL", writeAsCData = true)
        var sModel: String = "",
        /**
         * System manufacturer
         */
        @PropertyElement(name = "SMANUFACTURER", writeAsCData = true)
        var sManufacturer: String = "",
        /**
         * System Serial number
         */
        @PropertyElement(name = "SSN", writeAsCData = true)
        var serialNumber: String = "",
        /**
         * BIOS release date
         */
        @PropertyElement(name = "BDATE", writeAsCData = true)
        var bDate: Date = Date(),
        /**
         * BIOS version
         */
        @PropertyElement(name = "BVERSION", writeAsCData = true)
        var bVersion: String = "",
        /**
         * BIOS manufacturer
         */
        @PropertyElement(name = "BMANUFACTURER", writeAsCData = true)
        var bManufacturer: String = "",
        /**
         * BIOS Serial number
         */
        @PropertyElement(name = "BIOSSERIAL", writeAsCData = true)
        var biosSerial: String = "",
        /**
         * Motherboard manufacturer
         */
        @PropertyElement(name = "MMANUFACTURER", writeAsCData = true)
        var mManufacturer: String = "",
        /**
         * Motherboard Serial number
         */
        @PropertyElement(name = "MSN", writeAsCData = true)
        var msn: String = "",
        /**
         * Motherboard model
         */
        @PropertyElement(name = "MMODEL", writeAsCData = true)
        var mModel: String = "",
        /**
         * Asset tag
         */
        @PropertyElement(name = "ASSETTAG", writeAsCData = true)
        var assetTag: String = "",
        /**
         * Enclosure serial number
         */
        @PropertyElement(name = "ENCLOSURESERIAL", writeAsCData = true)
        var enclosureSerial: String = "",
        /**
         * Legacy chassis type
         */
        @Deprecated("Use InventoryResult.Hardware#chassisType instead")
        @PropertyElement(name = "TYPE", writeAsCData = true)
        var type: String? = null,
        /**
         * SKU number
         */
        @PropertyElement(name = "SKUNUMBER", writeAsCData = true)
        var skuNumber: String = ""
    ) {}

    /**
     * Current Account information
     */
    @Xml(name = "ACCOUNTINFO")
    data class AccountInfo(
        @PropertyElement(name = "KEYNAME", writeAsCData = true)
        var keyName: String = "",
        @PropertyElement(name = "KEYVALUE", writeAsCData = true)
        var keyValue: String = ""
    ) {}

    /**
     * Access log
     */
    @Xml(name = "ACCESSLOG")
    data class AccessLog(
        @PropertyElement(
            name = "LOGDATE",
            writeAsCData = true,
            converter = StdDateTimeConverter::class
        )
        var logDate: Date = Date(),
        @PropertyElement(name = "USERID", writeAsCData = true)
        var userId: String = ""
    ) {}

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
        var userId: String = "",
        /**
         * operating system version number
         */
        @Deprecated("Use InventoryResult.OperatingSystem#version and InventoryResult.OperatingSystem#kernelVersion instead")
        @PropertyElement(name = "OSVERSION", writeAsCData = true)
        var osVersion: String = "",
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
        var osName: String = "",
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
        var swap: Int = 0,
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
        var IP_ADDR: String = "0.0.0.0",
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
        var DEFAULT_GATEWAY: String? = null,
        /**
         * virtualization technology
         */
        @PropertyElement(name = "VMSYSTEM", writeAsCData = true, converter = VTConverter::class)
        var vmSystem: VirtualizationTechnology? = null,
        /**
         * virtual machine name the hypervisor (VM only)
         */
        @PropertyElement(name = "VMNAME", writeAsCData = true)
        var VM_NAME: String? = null,
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
    ) {}

    /**
     * Current Operating System
     */
    @Xml(name = "OPERATINGSYSTEM")
    data class OperatingSystem(
        /**
         * kernel name, ie 'freebsd', 'linux', 'hpux', 'win32', etc.
         */
        @PropertyElement(name = "KERNEL_NAME", writeAsCData = true)
        var kernelName: String = "",
        /**
         * kernel version, ie '2.6.32' on Linux, '5.2.x.y' on Windows Server 2003, etc.
         */
        @PropertyElement(name = "KERNEL_VERSION", writeAsCData = true)
        var kernelVersion: String = "",
        /**
         * operating system name ("Distributor ID" in LSB terms)
         *
         * ie. 'Debian', 'Ubuntu', 'CentOS', 'SUSE LINUX', 'Windows', 'OS X', 'FreeBSD', 'AIX', 'Android', etc.
         */
        @PropertyElement(name = "NAME", writeAsCData = true)
        var name: String = "",
        /**
         * operating system full name, ie 'Debian GNU/Linux unstable (sid)',
         * 'Microsoft(R) Windows(R) Server 2003, Enterprise Edition x64', etc.
         */
        @PropertyElement(name = "FULL_NAME", writeAsCData = true)
        var fullName: String = "",
        /**
         * operating system version ("Release" in LSB terms), ie '11.04' on
         * Ubuntu natty, '5.0.8' on Debian Lenny, '5.4' on CentOS 5.4, '2003'
         * for Windows Server 2003, etc.
         */
        @PropertyElement(name = "VERSION", writeAsCData = true)
        var version: String = "",
        /**
         * operating system minor version
         */
        @PropertyElement(name = "SERVICE_PACK", writeAsCData = true)
        var servicePack: String = "",
        /**
         * operating system installation date
         */
        @PropertyElement(name = "INSTALL_DATE", writeAsCData = true, converter = StdDateTimeConverter::class)
        var installDate: Date = Date(),
        @PropertyElement(name = "FQDN", writeAsCData = true)
        var fqdn: String? = null,
        @PropertyElement(name = "DNS_DOMAIN")
        var dnsDomain: String? = null,
        @PropertyElement(name = "HOSTID", writeAsCData = true)
        var hostId: String? = null,
        @PropertyElement(name = "SSH_KEY", writeAsCData = true)
        var sshKey: String? = null,
        /**
         * operating system architecture
         */
        @PropertyElement(name = "ARCH", writeAsCData = true)
        var arch: String? = null,
        /**
         * computer boot date, ie '2012-12-09 15:58:20'
         */
        @PropertyElement(name = "BOOT_TIME", writeAsCData = true, converter = StdDateTimeConverter::class)
        var bootTime: Date? = null,
        @Element
        var timezone: InventoryTimeZone = InventoryTimeZone()
    ) {
        @Xml(name = "TIMEZONE")
        data class InventoryTimeZone(
            /**
             * time zone name, ie 'Europe/Paris' or 'CEST'
             */
            @PropertyElement(name = "NAME", writeAsCData = true)
            var name: String = "",
            /**
             * time zone offset to UTC, ie '+0200'
             */
            @PropertyElement(name = "OFFSET", writeAsCData = true)
            var offset: String = ""
        ) {}
    }

    @Xml(name = "ANTIVIRUS")
    data class Antivirus(
        /**
         * company name
         */
        @PropertyElement(name = "COMPANY", writeAsCData = true)
        var company: String = "",
        @PropertyElement(name = "NAME", writeAsCData = true)
        var name: String = "",
        /**
         * unique ID
         */
        @PropertyElement(name = "GUID", writeAsCData = true)
        var guid: String = "",
        /**
         * whether the antivirus is enabled (0|1)
         */
        @PropertyElement(name = "ENABLED", writeAsCData = true, converter = BoolToIntConverter::class)
        var enabled: Boolean = true,
        /**
         * whether the antivirus is up to date (0|1)
         */
        @PropertyElement(name = "UPTODATE", writeAsCData = true, converter = BoolToIntConverter::class)
        var upToDate: Boolean = false,
        @PropertyElement(name = "VERSION", writeAsCData = true)
        var version: String? = null,
        /**
         * License expiration date, in DD/MM/YYYY format
         */
        @PropertyElement(name = "EXPIRATION", writeAsCData = true, converter = StdDateTimeConverter::class)
        var expiration: Date? = null,
        /**
         * signatures base creation
         */
        @PropertyElement(name = "BASE_CREATION", writeAsCData = true)
        var BASE_CREATION: String? = null,
        /**
         * signatures base version
         */
        @PropertyElement(name = "BASE_VERSION", writeAsCData = true)
        var BASE_VERSION: String? = null
    ) {}

    @Xml(name = "BATTERIES")
    data class Battery(
        @PropertyElement(name = "CHEMISTRY", writeAsCData = true)
        var chemistry: String? = null,
        /**
         * manufacturing date
         */
        @PropertyElement(name = "DATE", writeAsCData = true, converter = StdDateConverter::class)
        var date: Date? = null,
        /**
         * battery name
         */
        @PropertyElement(name = "NAME", writeAsCData = true)
        var name: String = "",
        /**
         * battery serial number
         */
        @PropertyElement(name = "SERIAL", writeAsCData = true)
        var serial: String? = null,
        /**
         * battery manufacturer
         */
        @PropertyElement(name = "MANUFACTURER", writeAsCData = true)
        var manufacturer: String? = null,
        /**
         * battery max capacity (the maximum capacity by design), in mWh
         */
        @PropertyElement(name = "CAPACITY", writeAsCData = true)
        var capacity: Int? = null,
        /**
         * battery real max capacity (decreases as the battery gets old), in mWh
         */
        @PropertyElement(name = "REAL_CAPACITY", writeAsCData = true)
        var realCapacity: Int? = null,
        /**
         * battery voltage, in mV
         */
        @PropertyElement(name = "VOLTAGE", writeAsCData = true)
        var voltage: Int? = null
    ) {}

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
    ) {}

    @Xml(name = "CPUS")
    data class Cpu(
        /**
         * total CPU cache size, in KB
         */
        @PropertyElement(name = "CACHE", writeAsCData = true)
        var cache: Int? = null,
        /**
         * number of cores
         */
        @PropertyElement(name = "CORE", writeAsCData = true)
        var core: Int = 1,
        /**
         * total available cores, as CORE only reports enabled count
         */
        @PropertyElement(name = "CORECOUNT", writeAsCData = true)
        var coreCount: Int? = null,
        @PropertyElement(name = "DESCRIPTION", writeAsCData = true)
        var description: String? = null,
        /**
         * CPU manufacturer, ie 'Intel', 'AMD', etc.
         */
        @PropertyElement(name = "MANUFACTURER", writeAsCData = true)
        var manufacturer: String? = null,
        /**
         * CPU name, ie 'Intel(R) Core(TM)2 Duo CPU P8600  @ 2.40GHz'
         */
        @PropertyElement(name = "NAME", writeAsCData = true)
        var name: String = "",
        /**
         * number of threads per core
         */
        @PropertyElement(name = "THREAD", writeAsCData = true)
        var thread: Int? = null,
        /**
         * CPU serial number
         */
        @PropertyElement(name = "SERIAL", writeAsCData = true)
        var serial: String? = null,
        /**
         * stepping value
         */
        @PropertyElement(name = "STEPPING", writeAsCData = true)
        var stepping: String? = null,
        /**
         * family name
         */
        @PropertyElement(name = "FAMILYNAME", writeAsCData = true)
        var familyName: String? = null,
        /**
         * family value
         */
        @PropertyElement(name = "FAMILYNUMBER", writeAsCData = true)
        var familyNumber: String? = null,
        /**
         * model value
         */
        @PropertyElement(name = "MODEL", writeAsCData = true)
        var model: String? = null,
        /**
         * CPU frequency, in MHz
         */
        @PropertyElement(name = "SPEED", writeAsCData = true)
        var speed: Int? = null,
        @PropertyElement(name = "ID", writeAsCData = true)
        var id: String? = null,
        /**
         * CPU Architecture
         */
        @PropertyElement(name = "ARCH", writeAsCData = true, converter = CpuArchConverter::class)
        var arch: CpuArch = CpuArch.ARM
    ) {}

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
    ) {}

    @Xml(name = "ENVS")
    data class Env(
        @PropertyElement(name = "KEY", writeAsCData = true)
        var key: String = "",
        @PropertyElement(name = "VAL", writeAsCData = true)
        var value: String? = null
    ) {}

    /**
     * Firewall configuration
     */
    @Xml(name = "FIREWALL")
    data class Firewall(
        /**
         * active connection's interface (Windows only)
         */
        @PropertyElement(name = "DESCRIPTION", writeAsCData = true)
        var description: String? = null,
        /**
         * active connection's ip (Windows only)
         */
        @PropertyElement(name = "IPADDRESS", writeAsCData = true)
        var ipAddress: String? = null,
        /**
         * active connection's ip v6 (Windows only)
         */
        @PropertyElement(name = "IPADDRESS6", writeAsCData = true)
        var ipAddress6: String? = null,
        /**
         * firewall profile (Windows only)
         */
        @PropertyElement(name = "PROFILE", writeAsCData = true)
        var profile: String? = null,
        /**
         * firewall status
         */
        @PropertyElement(name = "STATUS", writeAsCData = true)
        var status: String = ""
    ) {}

    @Xml(name = "INPUTS")
    data class Input(
        @PropertyElement(name = "NAME", writeAsCData = true)
        var name: String = "",
        @PropertyElement(name = "MANUFACTURER", writeAsCData = true)
        var manufacturer: String? = null,
        @PropertyElement(name = "CAPTION", writeAsCData = true)
        var caption: String? = null,
        @PropertyElement(name = "DESCRIPTION", writeAsCData = true)
        var description: String? = null,
        @PropertyElement(name = "INTERFACE", writeAsCData = true)
        var inputInterface: String? = null,
        @PropertyElement(name = "LAYOUT", writeAsCData = true)
        var layout: String? = null,
        @PropertyElement(name = "POINTINGTYPE", writeAsCData = true)
        var pointingType: String? = null,
        @PropertyElement(name = "TYPE", writeAsCData = true)
        var type: String? = null
    ) {}

    @Xml(name = "STORAGES")
    data class Storage(
        @Element(name = "DESCRIPTION")
        var description: String = "",
        @PropertyElement(name = "DISKSIZE")
        var diskSize: Long = 0L,
        @Element(name = "NAME")
        var name: String = "",
        @Element(name = "TYPE")
        var type: String = ""
    ) {}
}
