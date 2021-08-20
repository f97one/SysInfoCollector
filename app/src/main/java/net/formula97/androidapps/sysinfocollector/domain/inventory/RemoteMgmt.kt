package net.formula97.androidapps.sysinfocollector.domain.inventory

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "REMOTE_MGMT")
data class RemoteMgmt(
    @PropertyElement(name = "ID", writeAsCData = true)
    var id: String? = null,
    @PropertyElement(name = "TYPE", writeAsCData = true)
    var type: String? = null
)
