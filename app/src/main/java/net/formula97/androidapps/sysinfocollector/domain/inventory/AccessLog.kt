package net.formula97.androidapps.sysinfocollector.domain.inventory

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml
import net.formula97.androidapps.sysinfocollector.logic.converter.StdDateTimeConverter
import java.util.*

/**
 * Access log
 */
@Xml(name = "ACCESSLOG")
data class AccessLog(
    @PropertyElement(name = "LOGDATE", writeAsCData = true, converter = StdDateTimeConverter::class)
    var logDate: Date = Date(),
    @PropertyElement(name = "USERID", writeAsCData = true)
    var userId: String = ""
) : InventoryCategory
