package net.formula97.androidapps.sysinfocollector.domain.inventory

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml
import net.formula97.androidapps.sysinfocollector.logic.converter.BoolToIntConverter
import net.formula97.androidapps.sysinfocollector.logic.converter.StdDateConverter
import java.util.*

/**
 * License information
 */
@Xml(name = "LICENSEINFOS")
data class LicenseInfo(
    /**
     * name
     */
    @PropertyElement(name = "NAME", writeAsCData = true)
    var name: String = "",
    /**
     * full name
     */
    @PropertyElement(name = "FULLNAME", writeAsCData = true)
    var FULL_NAME: String? = null,
    /**
     * registration key
     */
    @PropertyElement(name = "KEY", writeAsCData = true)
    var key: String? = null,
    /**
     * components covered
     */
    @PropertyElement(name = "COMPONENTS", writeAsCData = true)
    var components: String? = null,
    @PropertyElement(name = "TRIAL", writeAsCData = true)
    var trial: String? = null,
    @PropertyElement(name = "UPDATE", writeAsCData = true)
    var update: String? = null,
    @PropertyElement(name = "OEM", writeAsCData = true, converter = BoolToIntConverter::class)
    var oem: Boolean = false,
    @PropertyElement(name = "ACTIVATION_DATE", writeAsCData = true, converter = StdDateConverter::class)
    var activationDate: Date? = null,
    /**
     * installation ID
     */
    @PropertyElement(name = "PRODUCTID", writeAsCData = true)
    var productId: String? = null
): InventoryCategory
