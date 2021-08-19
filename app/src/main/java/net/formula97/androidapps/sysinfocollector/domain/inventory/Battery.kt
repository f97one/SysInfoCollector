package net.formula97.androidapps.sysinfocollector.domain.inventory

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml
import net.formula97.androidapps.sysinfocollector.logic.converter.StdDateConverter
import java.util.*

@Xml(name = "BATTERIES")
data class Battery(
    @PropertyElement(name = "CHEMISTRY", writeAsCData = true)
    var chemistry: String? = null,
    /**
     * manufacturing date
     */
    @PropertyElement(name = "DATE", writeAsCData = true, converter = StdDateConverter::class)
    var date: Date? = null,
    /**
     * battery name
     */
    @PropertyElement(name = "NAME", writeAsCData = true)
    var name: String = "",
    /**
     * battery serial number
     */
    @PropertyElement(name = "SERIAL", writeAsCData = true)
    var serial: String? = null,
    /**
     * battery manufacturer
     */
    @PropertyElement(name = "MANUFACTURER", writeAsCData = true)
    var manufacturer: String? = null,
    /**
     * battery max capacity (the maximum capacity by design), in mWh
     */
    @PropertyElement(name = "CAPACITY", writeAsCData = true)
    var capacity: Int? = null,
    /**
     * battery real max capacity (decreases as the battery gets old), in mWh
     */
    @PropertyElement(name = "REAL_CAPACITY", writeAsCData = true)
    var realCapacity: Int? = null,
    /**
     * battery voltage, in mV
     */
    @PropertyElement(name = "VOLTAGE", writeAsCData = true)
    var voltage: Int? = null
) : InventoryCategory
