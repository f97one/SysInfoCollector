package net.formula97.androidapps.sysinfocollector.logic.converter

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "CAMERAS")
data class Camera(
    /**
     * Camera resolution, ie '1200x800'
     */
    @PropertyElement(name = "RESOLUTION", writeAsCData = true)
    var resolution: String = "",
    /**
     * Direction the camera faces, relative to device screen
     */
    @PropertyElement(name = "LENSFACING", writeAsCData = true)
    var lensFacing: String = "",
    /**
     * Whether this camera device has a flash unit
     */
    @PropertyElement(name = "FLASHUNIT", writeAsCData = true, converter = BoolToIntConverter::class)
    var flashUnit: Boolean = false,
    /**
     * Image output formats
     */
    @Element(name = "IMAGEFORMATS")
    var imageFormats: List<String> = listOf(),
    /**
     * Orientation camera - Degrees of clockwise rotation
     */
    @PropertyElement(name = "ORIENTATION", writeAsCData = true)
    var orientation: String? = null,
    /**
     * List of focal lengths - Units in Millimeters
     */
    @PropertyElement(name = "FOCALLENGHT", writeAsCData = true)
    var focalLenght: String? = null,
    /**
     * This is the physical size of the sensor - Units in Millimeters
     */
    @PropertyElement(name = "SENSORSIZE", writeAsCData = true)
    var sensorSize: String? = null,
    /**
     * Name of the Manufacturer
     */
    @PropertyElement(name = "MANUFACTURER", writeAsCData = true)
    var manufacturer: String? = null,
    /**
     * Video Camera resolution, ie '1200x800'
     */
    @PropertyElement(name = "RESOLUTIONVIDEO", writeAsCData = true)
    var resolutionVideo: String? = null,
    /**
     * Name of the Model
     */
    @PropertyElement(name = "MODEL", writeAsCData = true)
    var model: String? = null,
    /**
     * List of interfaces and protocols about Camera
     */
    @Element(name = "SUPPORTS")
    var supports: List<String> = listOf()
)
