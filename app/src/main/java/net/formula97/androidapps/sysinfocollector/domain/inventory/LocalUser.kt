package net.formula97.androidapps.sysinfocollector.domain.inventory

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "LOCAL_USERS")
data class LocalUser(
    /**
     * uid
     */
    @PropertyElement(name = "ID", writeAsCData = true)
    var id: String = "",
    /**
     * display name of user
     */
    @PropertyElement(name = "NAME", writeAsCData = true)
    var name: String = "",
    /**
     * login user id
     */
    @PropertyElement(name = "LOGIN", writeAsCData = true)
    var login: String? = null,
    /**
     * home directory of user
     */
    @PropertyElement(name = "HOME", writeAsCData = true)
    var home: String? = null,
    /**
     * login shell of user
     */
    @PropertyElement(name = "SHELL", writeAsCData = true)
    var shell: String? = null,
): InventoryCategory
