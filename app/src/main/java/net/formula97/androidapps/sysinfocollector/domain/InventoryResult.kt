package net.formula97.androidapps.sysinfocollector.domain

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml
import net.formula97.androidapps.sysinfocollector.domain.inventory.*
import net.formula97.androidapps.sysinfocollector.logic.converter.*
import java.lang.Process
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
        var licenseInfos: List<LicenseInfo> = listOf(),
        @Element
        var localGroups: List<LocalGroup> = listOf(),
        @Element
        var loginUsers: List<LocalUser> = listOf(),
        @Element
        var memories: List<Memory> = listOf(),
        @Element
        var firmwares: List<Firmware> = listOf(),
        @Element
        var monitors: List<Monitor> = listOf(),
        @Element
        var storages: List<Storage> = listOf(),
        @Element
        var modems: List<Modem> = listOf(),
        @Element
        var networks: List<Network> = listOf(),
        @Element
        var physicalVolumes: List<PhysicalVolume> = listOf(),
        @Element
        var ports: List<Port> = listOf(),
        @Element
        var printers: List<Printer> = listOf(),
        @Element
        var processes: List<Process> = listOf(),
        @Element
        var registry: Registry? = null,
        @Element
        var rudder: Rudder? = null,
    )
}
