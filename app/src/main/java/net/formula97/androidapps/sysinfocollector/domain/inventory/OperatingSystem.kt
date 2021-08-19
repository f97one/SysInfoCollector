package net.formula97.androidapps.sysinfocollector.domain.inventory

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml
import net.formula97.androidapps.sysinfocollector.logic.converter.StdDateTimeConverter
import java.util.*

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
) : InventoryCategory {
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
    ) : InventoryCategory {}
}
