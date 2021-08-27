package net.formula97.androidapps.sysinfocollector.logic.factory

import android.content.Context
import android.hardware.usb.UsbManager
import net.formula97.androidapps.sysinfocollector.domain.inventory.UsbDevice

class UsbFactory: AbstractInventoryBuilder<UsbDevice>(), ContextInventoryInjector<UsbDevice> {
    override fun fromContext(context: Context): UsbDevice {
        val devices = listFromContext(context)
        return if (devices.isEmpty()) UsbDevice() else devices[0]
    }

    override fun listFromContext(context: Context): MutableList<UsbDevice> {
        val ret = mutableListOf<UsbDevice>()

        val usbMgr = context.getSystemService(Context.USB_SERVICE) as UsbManager
        usbMgr.deviceList.forEach { (k, v) -> ret.add(UsbDevice().apply {
            name = k
            usbClassId = v.deviceClass.toString()
            usbSubClass = v.deviceSubclass.toString()
            vendorId = v.vendorId.toString()
            productId = v.productId.toString()
            manufacturer = v.manufacturerName
            caption = v.productName
            serial = v.serialNumber
        })}

        return ret
    }
}