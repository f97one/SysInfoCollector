package net.formula97.androidapps.sysinfocollector.domain.inventory

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml
import net.formula97.androidapps.sysinfocollector.domain.CpuArch
import net.formula97.androidapps.sysinfocollector.logic.converter.BoolToIntConverter
import net.formula97.androidapps.sysinfocollector.logic.converter.CpuArchConverter
import net.formula97.androidapps.sysinfocollector.logic.converter.UsDateConverter
import java.util.*

@Xml(name = "SOFTWARES")
data class Software(
    @PropertyElement(name = "COMMENTS")
    var comments: String? = null,
    @PropertyElement(name = "FILESIZE", writeAsCData = true)
    var fileSize: Long? = null,
    @PropertyElement(name = "FOLDER", writeAsCData = true)
    var folder: String? = null,
    /**
     * information source, ie 'registry', 'rpm', 'deb', etc.
     */
    @PropertyElement(name = "FROM", writeAsCData = true)
    var from: String? = null,
    @PropertyElement(name = "HELPLINK", writeAsCData = true)
    var helpLink: String? = null,
    /**
     * installation date, in DD/MM/YYYY format
     */
    @PropertyElement(name = "INSTALLDATE", writeAsCData = true, converter = UsDateConverter::class)
    var installDate: Date = Date(),
    @PropertyElement(name = "NAME", writeAsCData = true)
    var name: String = "",
    /**
     * whether the software can be uninstalled
     */
    @PropertyElement(name = "NO_REMOVE", writeAsCData = true, converter = BoolToIntConverter::class)
    var noRemove: Boolean? = null,
    @PropertyElement(name = "RELEASE_TYPE", writeAsCData = true)
    var releaseType: String? = null,
    @PropertyElement(name = "PUBLISHER", writeAsCData = true)
    var publisher: String? = null,
    @PropertyElement(name = "UNINSTALL_STRING", writeAsCData = true)
    var uninstallString: String? = null,
    @PropertyElement(name = "URL_INFO_ABOUT")
    var urlInfoAbout: String? = null,
    @PropertyElement(name = "VERSION", writeAsCData = true)
    var version: String = "",
    @PropertyElement(name = "VERSION_MINOR", writeAsCData = true)
    var versionMinor: String? = null,
    @PropertyElement(name = "VERSION_MAJOR", writeAsCData = true)
    var versionMajor: String? = null,
    /**
     * software GUID (Windows only)
     */
    @PropertyElement(name = "GUID", writeAsCData = true)
    var guid: String? = null,
    /**
     * software architecture
     */
    @PropertyElement(name = "ARCH", writeAsCData = true, converter = CpuArchConverter::class)
    var arch: CpuArch? = null,
    /**
     * software owner name
     */
    @PropertyElement(name = "USERNAME", writeAsCData = true)
    var username: String? = null,
    /**
     * software owner ID
     */
    @PropertyElement(name = "USERID", writeAsCData = true)
    var userId: String? = null,
    /**
     * software system category
     */
    @PropertyElement(name = "SYSTEM_CATEGORY", writeAsCData = true)
    var systemCategory: String? = null,
): InventoryCategory
