package net.formula97.androidapps.sysinfocollector.domain.inventory

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

/**
 * Current Account information
 */
@Xml(name = "ACCOUNTINFO")
data class AccountInfo(
    @PropertyElement(name = "KEYNAME", writeAsCData = true)
    var keyName: String = "",
    @PropertyElement(name = "KEYVALUE", writeAsCData = true)
    var keyValue: String = ""
) : InventoryCategory
