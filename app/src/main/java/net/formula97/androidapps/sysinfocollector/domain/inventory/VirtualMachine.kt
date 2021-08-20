package net.formula97.androidapps.sysinfocollector.domain.inventory

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml
import net.formula97.androidapps.sysinfocollector.domain.VirtualizationTechnology
import net.formula97.androidapps.sysinfocollector.domain.VmStatus
import net.formula97.androidapps.sysinfocollector.logic.converter.UuidConverter
import net.formula97.androidapps.sysinfocollector.logic.converter.VmStatusConverter
import java.util.*

@Xml(name = "VIRTUALMACHINES")
data class VirtualMachine(
    /**
     * name
     */
    @PropertyElement(name = "NAME", writeAsCData = true)
    var name: String = "",
    /**
     * UUID
     */
    @PropertyElement(name = "UUID", writeAsCData = true, converter = UuidConverter::class)
    var uuid: UUID? = null,
    /**
     * status
     */
    @PropertyElement(name = "STATUS", writeAsCData = true, converter = VmStatusConverter::class)
    var status: VmStatus? = null,
    /**
     * virtualization software, ie 'VmWare ESX'
     */
    @PropertyElement(name = "SUBSYSTEM", writeAsCData = true)
    var subSystem: String? = null,
    /**
     * virtualization technology
     */
    @PropertyElement(name = "VMTYPR", writeAsCData = true)
    var vmType: VirtualizationTechnology? = null,
    /**
     * memory size, in MB
     */
    @PropertyElement(name = "MEMORY", writeAsCData = true)
    var memory: Double? = null,
    /**
     * CPU numbers
     */
    @PropertyElement(name = "VCPU", writeAsCData = true)
    var vCpu: Int = 0,
    /**
     * id
     */
    @PropertyElement(name = "VMID", writeAsCData = true)
    var vmId: String? = null,
    /**
     * list of the MAC addresses of the virtual machine, with '/' as delimiter
     */
    @PropertyElement(name = "MAC", writeAsCData = true)
    var mac: String? = null,
    @PropertyElement(name = "COMMENT", writeAsCData = true)
    var comment: String? = null,
    @PropertyElement(name = "OWNER", writeAsCData = true)
    var owner: String? = null,
    /**
     * image used for creation (Docker image for instance)
     */
    @PropertyElement(name = "IMAGE", writeAsCData = true)
    var image: String? = null,
): InventoryCategory
