package net.formula97.androidapps.sysinfocollector.domain.inventory

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml
import net.formula97.androidapps.sysinfocollector.logic.converter.UuidConverter
import java.util.*

@Xml(name = "RUDDER")
data class Rudder(
    @PropertyElement(name = "AGENT")
    var agent: String? = null,
    @PropertyElement(name = "UUID", writeAsCData = true, converter = UuidConverter::class)
    var uuid: UUID? = null,
    @PropertyElement(name = "HOSTNAME", writeAsCData = true)
    var hostname: String? = null,
    @PropertyElement(name = "SERVER_ROLES", writeAsCData = true)
    var serverRoles: String? = null,
    @PropertyElement(name = "AGENT_CAPABILITIES", writeAsCData = true)
    var agentCapabilities: String? = null
)
