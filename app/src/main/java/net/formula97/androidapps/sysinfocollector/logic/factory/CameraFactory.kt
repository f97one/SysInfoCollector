package net.formula97.androidapps.sysinfocollector.logic.factory

import android.content.Context
import android.content.pm.PackageManager
import android.graphics.ImageFormat
import android.hardware.camera2.CameraCharacteristics
import android.hardware.camera2.CameraManager
import android.media.MediaRecorder
import net.formula97.androidapps.sysinfocollector.domain.inventory.Camera
import java.util.stream.Collectors
import kotlin.math.roundToInt

class CameraFactory: AbstractInventoryBuilder<Camera>(), ContextInventoryInjector<Camera> {

    override fun fromContext(context: Context): Camera {
        throwIfNotHasFeature(context, PackageManager.FEATURE_CAMERA_ANY)

        val camMgr = context.getSystemService(Context.CAMERA_SERVICE) as CameraManager
        val camIds = camMgr.cameraIdList.sortedArray()

        return camera(context, camMgr, camIds[0])
    }

    private fun camera(context: Context, camMgr: CameraManager, camId: String): Camera {
        val camChar = camMgr.getCameraCharacteristics(camId)
        return Camera().apply {
            resolution = getResolutions(camChar)
            lensFacing = getFacingState(camChar)
            flashUnit = hasFlashUnit(camChar)
            imageFormats = getImageFormats(camChar)
            orientation = getOrientation(camChar)
            focalLenght = getFocalLength(camChar)
            sensorSize = getSensorSize(camChar)
            resolutionVideo = getVideoResolutions(camChar)
            manufacturer = getManufacturer(context, camId)
            model = getModel(context, camId)
        }
    }

    override fun listFromContext(context: Context): MutableList<Camera> {
        throwIfNotHasFeature(context, PackageManager.FEATURE_CAMERA_ANY)

        val camMgr = context.getSystemService(Context.CAMERA_SERVICE) as CameraManager
        val camList = mutableListOf<Camera>()
        camMgr.cameraIdList.sortedArray().forEach { cId -> camList.add(camera(context, camMgr, cId)) }

        return camList
    }

    /**
     * Collects cameras' resolutions.
     *
     * @param cameraCharacteristics target [CameraCharacteristics]
     * @return comma-separated resolutions, if not applicable, returns just "N/A"
     */
    private fun getResolutions(cameraCharacteristics: CameraCharacteristics): String {
        val resolutions = mutableListOf<String>()

        val currentSize = cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)
        if (currentSize == null) {
            return NOT_APPLICABLE
        } else {
            val outputSize = currentSize.getOutputSizes(ImageFormat.JPEG)

            if (outputSize.isEmpty()) {
                val rect = cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE)
                if (rect != null) {
                    resolutions.add("${rect.width()}x${rect.height()}")
                } else {
                    resolutions.add("N/A")
                }
            } else {
                outputSize.forEach { s -> resolutions.add("${s.width}x${s.height}") }
            }
        }

        return resolutions.joinToString(",")
    }

    /**
     * Collects camera' facing.
     *
     * @param cameraCharacteristics target [CameraCharacteristics]
     * @return "FRONT", "BACK", or "EXTERNAL", if not applicable, returns just "N/A"
     */
    private fun getFacingState(cameraCharacteristics: CameraCharacteristics): String {
        val facing = cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)

        return if (facing == null) {
            NOT_APPLICABLE
        } else {
            when(facing) {
                0 -> "FRONT"
                1 -> "BACK"
                2 -> "EXTERNAL"
                else -> NOT_APPLICABLE
            }
        }
    }

    /**
     * Detects camera's flash capability.
     *
     * @param cameraCharacteristics target [CameraCharacteristics]
     * @return true if camera has flash capability, otherwise false(capability unknown included)
     */
    private fun hasFlashUnit(cameraCharacteristics: CameraCharacteristics): Boolean {
        return cameraCharacteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE) ?: return false
    }

    /**
     * Collects cameras' image formats.
     *
     * @param cameraCharacteristics target [CameraCharacteristics]
     * @return list of image formats, if can't detect, returns "UNKNOWN"
     */
    private fun getImageFormats(cameraCharacteristics: CameraCharacteristics): List<String> {
        val formats = mutableListOf<String>()

        val confMap = cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)
        confMap!!.outputFormats.forEach { i ->
            val s = when(i) {
                ImageFormat.RGB_565 -> "RGB_565"
                ImageFormat.NV16 -> "NV16"
                ImageFormat.NV21 -> "NV21"
                ImageFormat.YUY2 -> "YUY2"
                ImageFormat.RAW_SENSOR -> "RAW_SENSOR"
                ImageFormat.PRIVATE -> "PRIVATE"
                ImageFormat.YUV_420_888 -> "YUV_420_888"
                ImageFormat.RAW10 -> "RAW10"
                ImageFormat.RAW12 -> "RAW12"
                ImageFormat.YUV_422_888 -> "YUV_422_888"
                ImageFormat.YUV_444_888 -> "YUV_444_888"
                ImageFormat.FLEX_RGB_888 -> "FLEX_RGB_888"
                ImageFormat.FLEX_RGBA_8888 -> "FLEX_RGBA_8888"
                ImageFormat.YCBCR_P010 -> "YCBCR_P010"
                ImageFormat.JPEG -> "JPEG"
                ImageFormat.DEPTH_POINT_CLOUD -> "DEPTH_POINT_CLOUD"
                ImageFormat.Y8 -> "Y8"
                ImageFormat.YV12 -> "YV12"
                ImageFormat.DEPTH16 -> "DEPTH16"
                ImageFormat.HEIC -> "HEIC"
                ImageFormat.DEPTH_JPEG -> "DEPTH_JPEG"

                else -> "UNKNOWN"
            }
            formats.add(s)
        }

        return formats
    }

    /**
     * Collects cameras' orientation.
     *
     * @param cameraCharacteristics target [CameraCharacteristics]
     * @return degree of camera orientation, if not applicable, returns just "N/A"
     */
    private fun getOrientation(cameraCharacteristics: CameraCharacteristics): String {
        val o = cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)
        return o?.toString() ?: NOT_APPLICABLE
    }

    /**
     * Collects cameras' focal length.
     *
     * @param cameraCharacteristics target [CameraCharacteristics]
     * @return comma-separated cameras' focal length, if not applicable, returns just "N/A"
     */
    private fun getFocalLength(cameraCharacteristics: CameraCharacteristics): String {
        val flArr = cameraCharacteristics.get(CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS)
            ?: return NOT_APPLICABLE

        return flArr.joinToString(",")
    }

    /**
     * Collects cameras' sensor size.
     *
     * @param cameraCharacteristics target [CameraCharacteristics]
     * @return sensor size, if not applicable, returns just "N/A"
     */
    private fun getSensorSize(cameraCharacteristics: CameraCharacteristics): String {
        val sizeF = cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_PHYSICAL_SIZE)
            ?: return NOT_APPLICABLE

        val width = ((sizeF.width * 100) / 100F).roundToInt()
        val height = ((sizeF.height * 100) / 100F).roundToInt()
        return if (width <= 0 && height <= 0) NOT_APPLICABLE else "${width}x${height}"
    }

    /**
     * Collects cameras' resolutions of Video.
     *
     * @param cameraCharacteristics target [CameraCharacteristics]
     * @return comma-separated resolutions, if not applicable, returns just "N/A"
     */
    private fun getVideoResolutions(cameraCharacteristics: CameraCharacteristics): String {
        val confMap = cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)
            ?: return NOT_APPLICABLE
        val sizes = confMap.getOutputSizes(MediaRecorder::class.java) ?: return NOT_APPLICABLE

        val reso = mutableListOf<String>()
        sizes.forEach { reso.add("${it.width}x${it.height}") }

        return reso.joinToString(",")
    }

    /**
     * Reads cameras' manufacturer name.
     *
     * @param context target [Context]
     * @param camId target camera's ID (mainly integer starts 0)
     * @return camera's manufacturer name, if not found returns just "N/A"
     */
    private fun getManufacturer(context: Context, camId: String): String {
        var camInfoModel = readLinesFromFile(path = "/proc/hw_info/camera_info")
        if (camInfoModel.isEmpty()) {
            camInfoModel = readLinesFromFile(path = "/proc/driver/camera_info")
        }

        // sets return val to "N/A" as default
        var ret = NOT_APPLICABLE

        if (camInfoModel.isNotEmpty() && camInfoModel.contains(char = ';')) {
            val model = camInfoModel.split(";", ignoreCase = true, limit = 2)[camId.toInt()]
            if (model.contains(":")) {
                val vendorTag = model.split(":", ignoreCase = true, limit = 2)[1].trim()
                if (vendorTag.isNotEmpty()) {
                    val camVendors = loadCameraVendors(context)
                    // if not found, return val is still "N/A"
                    ret = camVendors.entries.filter { vendorTag.startsWith(it.key) }.map { it.value }.first()
                }
            }
        }

        return ret
    }

    /**
     * Reads cameras' model name.
     *
     * @param context target [Context]
     * @param camId target camera's ID (mainly integer starts 0)
     * @return camera's model name, if not found returns just "N/A"
     */
    private fun getModel(context: Context, camId: String): String {
        var camInfoModel = readLinesFromFile(path = "/proc/driver/camera_info")
        if (camInfoModel.isEmpty()) {
            camInfoModel = readLinesFromFile(path = "/proc/hw_info/camera_info")
        }

        // sets return val to "N/A" as default
        var ret = NOT_APPLICABLE

        if (camInfoModel.isNotEmpty()) {
            val model = camInfoModel.split(";", ignoreCase = true, limit = 2)[camId.toInt()]
            if (model.contains(":")) {
                ret = model.split(":", ignoreCase = true, limit= 2)[1]
            }
        }

        return ret
    }
}