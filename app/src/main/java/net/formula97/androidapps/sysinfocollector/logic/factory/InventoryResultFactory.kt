package net.formula97.androidapps.sysinfocollector.logic.factory

import android.content.Context
import net.formula97.androidapps.sysinfocollector.domain.InventoryResult

class InventoryResultFactory(val context: Context) {
    fun create(): InventoryResult {
        val pkgInfo = context.applicationContext.packageManager.getPackageInfo(context.packageName, 0)

        val content = InventoryResult.Content().apply {
            versionClient = pkgInfo.versionName

            batteries = BatteryFactory().listFromContext(context)
            bios = BiosFactory().fromContext(context)
            cameras = CameraFactory().listFromContext(context)
            hardware = HardwareFactory().fromContext(context)
            inputs = InputFactory().listFromContext(context)
            memories = listOf(MemoryFactory().from())
            networks = NetworkFactory().listFromContext(context)
            operatingSystem = OperatingSystemFactory().fromContext(context)
            softwares = SoftwareFactory().listFromContext(context)
            storages = StorageFactory().listFromContext(context)
            usbDevices = UsbFactory().listFromContext(context)
            videos = VideoFactory().listFromContext(context)
        }

        return InventoryResult(deviceId = content.hardware.name, content = content)
    }
}