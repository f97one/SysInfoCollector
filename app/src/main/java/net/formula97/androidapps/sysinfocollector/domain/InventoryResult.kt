package net.formula97.androidapps.sysinfocollector.domain

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml
import net.formula97.androidapps.sysinfocollector.logic.converter.StdDateTimeConverter
import java.util.*

@Xml(name = "REQUEST")
data class InventoryResult(
    @Element(name = "QUERY")
    var query: String = "INVENTORY",
    @Element(name = "DEVICEID")
    var deviceId: String = "",
    @Element(name = "CONTENT")
    var content: InventoryContent = InventoryContent()
) {}

@Xml(name = "CONTENT")
data class InventoryContent(
    @Element(name = "VERSIONCLIENT")
    var versionClient: String = "",
    @Element
    var strages: List<InventoryStorage> = listOf()
) {}

data class InventoryAccessLog(
    @PropertyElement(name = "LOGDATE", writeAsCData = true, converter = StdDateTimeConverter::class)
    var logDate: Date = Date()
) {}

@Xml(name = "STORAGES")
data class InventoryStorage(
    @Element(name = "DESCRIPTION")
    var description: String = "",
    @PropertyElement(name = "DISKSIZE")
    var diskSize: Long = 0L,
    @Element(name = "NAME")
    var name: String = "",
    @Element(name = "TYPE")
    var type: String = ""
) {}