package net.formula97.androidapps.sysinfocollector.domain.inventory

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "USERS")
data class User(
    @PropertyElement(name = "LOGIN", writeAsCData = true)
    var login: String? = null,
    /**
     * user domain (Windows only)
     */
    @PropertyElement(name = "DOMAIN", writeAsCData = true)
    var domain: String? = null
): InventoryCategory
