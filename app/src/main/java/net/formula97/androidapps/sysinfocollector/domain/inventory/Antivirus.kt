package net.formula97.androidapps.sysinfocollector.domain.inventory

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml
import net.formula97.androidapps.sysinfocollector.logic.converter.BoolToIntConverter
import net.formula97.androidapps.sysinfocollector.logic.converter.StdDateTimeConverter
import java.util.*

@Xml(name = "ANTIVIRUS")
data class Antivirus(
    /**
     * company name
     */
    @PropertyElement(name = "COMPANY", writeAsCData = true)
    var company: String = "",
    @PropertyElement(name = "NAME", writeAsCData = true)
    var name: String = "",
    /**
     * unique ID
     */
    @PropertyElement(name = "GUID", writeAsCData = true)
    var guid: String = "",
    /**
     * whether the antivirus is enabled (0|1)
     */
    @PropertyElement(name = "ENABLED", writeAsCData = true, converter = BoolToIntConverter::class)
    var enabled: Boolean = true,
    /**
     * whether the antivirus is up to date (0|1)
     */
    @PropertyElement(name = "UPTODATE", writeAsCData = true, converter = BoolToIntConverter::class)
    var upToDate: Boolean = false,
    @PropertyElement(name = "VERSION", writeAsCData = true)
    var version: String? = null,
    /**
     * License expiration date, in DD/MM/YYYY format
     */
    @PropertyElement(name = "EXPIRATION", writeAsCData = true, converter = StdDateTimeConverter::class)
    var expiration: Date? = null,
    /**
     * signatures base creation
     */
    @PropertyElement(name = "BASE_CREATION", writeAsCData = true)
    var BASE_CREATION: String? = null,
    /**
     * signatures base version
     */
    @PropertyElement(name = "BASE_VERSION", writeAsCData = true)
    var BASE_VERSION: String? = null
) : InventoryCategory
