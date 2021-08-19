package net.formula97.androidapps.sysinfocollector.domain.inventory

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml
import net.formula97.androidapps.sysinfocollector.domain.NetIFType
import net.formula97.androidapps.sysinfocollector.logic.converter.BoolToIntConverter
import net.formula97.androidapps.sysinfocollector.logic.converter.NetIFConverter

/**
 * a network configuration, ie a combination of an interface and an IP address
 */
@Xml(name = "NETWORKS")
data class Network(
    /**
     * interface name, ie 'eth0' on Linux, 'AMD PCNET Family Ethernet Adapter' on Windows
     */
    @PropertyElement(name = "DESCRIPTION", writeAsCData = true)
    var description: String? = null,
    /**
     * interface manufacturer
     */
    @PropertyElement(name = "MANUFACTURER", writeAsCData = true)
    var manufacturer: String? = null,
    /**
     * interface model
     */
    @PropertyElement(name = "MODEL", writeAsCData = true)
    var model: String? = null,
    /**
     * whether it is a remote management interface such as HP iLO, Sun SC, HP MP
     */
    @PropertyElement(name = "MANAGEMENT", writeAsCData = true, converter = BoolToIntConverter::class)
    var management: Boolean = false,
    /**
     * interface type
     */
    @PropertyElement(name = "TYPE", writeAsCData = true, converter = NetIFConverter::class)
    var type: NetIFType? = null,
    /**
     * whether it is a virtual interface
     */
    @PropertyElement(name = "VIRTUALDEV", writeAsCData = true, converter = BoolToIntConverter::class)
    var virtualDev: Boolean = false,
    /**
     * Physical Address of interface
     */
    @PropertyElement(name = "MACADDR", writeAsCData = true)
    var macAddr: String? = null,
    /**
     * World Wide Name [http://fr.wikipedia.org/wiki/World_Wide_Name]
     */
    @PropertyElement(name = "WWN", writeAsCData = true)
    var wwn: String? = null,
    /**
     * driver name
     */
    @PropertyElement(name = "DRIVER", writeAsCData = true)
    var driver: String? = null,
    @PropertyElement(name = "FIRMWARE", writeAsCData = true)
    var firmware: String? = null,
    /**
     * PCI slot name
     */
    @PropertyElement(name = "PCISLOT", writeAsCData = true)
    var pciSlot: String? = null,
    /**
     * PCI device ID
     */
    @PropertyElement(name = "PCIID", writeAsCData = true)
    var pciId: String? = null,
    /**
     * PCI device ID (windows only)
     */
    @PropertyElement(name = "PNPDEVICEID", writeAsCData = true)
    var pnpDeviceId: String? = null,
    @PropertyElement(name = "MTU", writeAsCData = true)
    var mtu: Int? = null,
    /**
     * interface speed, in Mb/s
     */
    @PropertyElement(name = "SPEED", writeAsCData = true)
    var speed: Double? = null,
    /**
     * interface status (up|down)
     */
    @PropertyElement(name = "STATUS", writeAsCData = true)
    var status: String? = null,
    /**
     * list of component interfaces, for aggregate and bridges, with ',' as delimiter
     */
    @PropertyElement(name = "SLAVES", writeAsCData = true)
    var slaves: String? = null,
    /**
     * actual interface for aliases
     */
    @PropertyElement(name = "BASE", writeAsCData = true)
    var base: String? = null,
    /**
     * IPv4 address
     */
    @PropertyElement(name = "IPADDRESS", writeAsCData = true)
    var ipAddress: String = "",
    @PropertyElement(name = "IPSUBNET", writeAsCData = true)
    var ipSubnet: String? = null,
    @PropertyElement(name = "IPMASK", writeAsCData = true)
    var ipMask: String? = null,
    /**
     * DHCP server IP address
     */
    @PropertyElement(name = "IPDHCP", writeAsCData = true)
    var ipDhcp: String? = null,
    /**
     * gateway IP address
     */
    @PropertyElement(name = "IPGATEWAY", writeAsCData = true)
    var ipGateway: String? = null,
    /**
     * IPv6 address of the interface
     */
    @PropertyElement(name = "IPADDRESS6", writeAsCData = true)
    var ipAddress6: String? = null,
    @PropertyElement(name = "IPSUBNET6", writeAsCData = true)
    var ipSubnet6: String? = null,
    @PropertyElement(name = "IPMASK6", writeAsCData = true)
    var ipMask6: String? = null,
    /**
     * wifi access point name
     */
    @PropertyElement(name = "WIFI_SSID", writeAsCData = true)
    var wifiSsid: String? = null,
    /**
     * wifi access point MAC address
     */
    @PropertyElement(name = "WIFI_BSSID", writeAsCData = true)
    var wifiBssid: String? = null,
    /**
     * wifi mode
     */
    @PropertyElement(name = "WIFI_MODE", writeAsCData = true)
    var wifiMode: String? = null,
    /**
     * wifi protocol version
     */
    @PropertyElement(name = "WIFI_VERSION", writeAsCData = true)
    var wifiVersion: String? = null
): InventoryCategory
