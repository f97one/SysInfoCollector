package net.formula97.androidapps.sysinfocollector.domain.inventory

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml
import net.formula97.androidapps.sysinfocollector.logic.converter.BoolToIntConverter

@Xml(name = "PRINTERS")
data class Printer(
   @PropertyElement(name = "COMMENT", writeAsCData = true)
   var comment: String? = null,
   @PropertyElement(name = "DESCRIPTION", writeAsCData = true)
   var description: String? = null,
   @PropertyElement(name = "DRIVER", writeAsCData = true)
   var driver: String? = null,
   @PropertyElement(name = "NAME", writeAsCData = true)
   var name: String = "",
   /**
    * whether it is a network printer
    */
   @PropertyElement(name = "NETWORK",writeAsCData = true, converter = BoolToIntConverter::class)
   var network: Boolean = false,
   @PropertyElement(name = "PORT", writeAsCData = true)
   var port: String? = null,
   /**
    * printer resolution, ie '600x600'
    */
   @PropertyElement(name = "RESOLUTION", writeAsCData = true)
   var resolution: String? = null,
   /**
    * whether it is a shared printer (Windows only)
    */
   @PropertyElement(name = "SHARED", writeAsCData = true, converter = BoolToIntConverter::class)
   var shared: Boolean? = null,
   @PropertyElement(name = "STATUS", writeAsCData = true)
   var status: String? = null,
   @PropertyElement(name = "ERRSTATUS", writeAsCData = true)
   var errStatus: String? = null,
   @PropertyElement(name = "SERVERNAME", writeAsCData = true)
   var serverName: String? = null,
   @PropertyElement(name = "SHARENAME", writeAsCData = true)
   var shareName: String? = null,
   @PropertyElement(name = "PRINTPROCESSOR", writeAsCData = true)
   var printProcessor: String? = null,
   /**
    * printer serial number
    */
   @PropertyElement(name = "SERIAL", writeAsCData = true)
   var serial: String? = null
): InventoryCategory
