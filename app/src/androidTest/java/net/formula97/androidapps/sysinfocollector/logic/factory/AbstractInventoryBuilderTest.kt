package net.formula97.androidapps.sysinfocollector.logic.factory

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AbstractInventoryBuilderTest {
    @Test
    fun createsCameraVendors() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val camVendors = CameraFactory().loadCameraVendors(context)

        assertEquals("OmniVision", camVendors["ov"])
        assertEquals("Sony", camVendors["imx"])
        assertEquals("Sony", camVendors["isx"])
        assertEquals("Samsung", camVendors["s5k"])
        assertEquals("Samsung", camVendors["s5c"])
        assertEquals("GalaxyCore", camVendors["gc"])
        assertEquals("Hynix", camVendors["hi"])
        assertEquals("Himax", camVendors["hm"])
        assertEquals("Seti", camVendors["siv"])
        assertEquals("Toshiba", camVendors["t4k"])
        assertEquals("Panasonic", camVendors["mn"])
        assertEquals("SiliconOptronics", camVendors["jx"])
        assertEquals("OnSemi", camVendors["ar"])
        assertEquals("Siliconfile", camVendors["sr"])
        assertEquals("Fujitsu", camVendors["m"])
    }

    @Test
    fun createsCpuManufacturers() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val cpuMan = CameraFactory().loadCpuManufacturer(context)

        assertEquals("MediaTek", cpuMan["mt"])
        assertEquals("MediaTek", cpuMan["mediatek"])
        assertEquals("Rockchip", cpuMan["rk"])
        assertEquals("Qualcomm", cpuMan["qcom"])
        assertEquals("Qualcomm", cpuMan["msm"])
        assertEquals("Qualcomm", cpuMan["apq"])
        assertEquals("Spreadtrum", cpuMan["sc"])
        assertEquals("Samsung", cpuMan["exynos"])
        assertEquals("Samsung", cpuMan["smdk"])
        assertEquals("Samsung", cpuMan["samsung"])
        assertEquals("HiSilicon", cpuMan["hi"])
        assertEquals("Marvell", cpuMan["pxa"])
        assertEquals("Amlogic", cpuMan["amlogic"])
    }

    @Test
    fun createsCpuFamilies() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val families = CameraFactory().loadCpuFamilies(context)

        assertEquals("Cortex-A5", families.filter { it.vId == 0x41 && it.id == 0xc05 }.get(index = 0).name)
        assertEquals("Cortex-A7", families.filter { it.vId == 0x41 && it.id == 0xc07 }.get(index = 0).name)
        assertEquals("Cortex-A8", families.filter { it.vId == 0x41 && it.id == 0xc08 }.get(index = 0).name)
        assertEquals("Cortex-A9", families.filter { it.vId == 0x41 && it.id == 0xc09 }.get(index = 0).name)
        assertEquals("Cortex-A12", families.filter { it.vId == 0x41 && it.id == 0xc0d }.get(index = 0).name)
        assertEquals("Cortex-A17", families.filter { it.vId == 0x41 && it.id == 0xc0e }.get(index = 0).name)
        assertEquals("Cortex-A15", families.filter { it.vId == 0x41 && it.id == 0xc0f }.get(index = 0).name)
        assertEquals("Cortex-A32", families.filter { it.vId == 0x41 && it.id == 0xd01 }.get(index = 0).name)
        assertEquals("Cortex-A32", families.filter { it.vId == 0x41 && it.id == 0xd01 }.get(index = 0).name)
        assertEquals("Cortex-A53", families.filter { it.vId == 0x41 && it.id == 0xd03 }.get(index = 0).name)
        assertEquals("Cortex-A35", families.filter { it.vId == 0x41 && it.id == 0xd04 }.get(index = 0).name)
        assertEquals("Cortex-A55", families.filter { it.vId == 0x41 && it.id == 0xd05 }.get(index = 0).name)
        assertEquals("Cortex-A57", families.filter { it.vId == 0x41 && it.id == 0xd07 }.get(index = 0).name)
        assertEquals("Cortex-A72", families.filter { it.vId == 0x41 && it.id == 0xd08 }.get(index = 0).name)
        assertEquals("Cortex-A73", families.filter { it.vId == 0x41 && it.id == 0xd09 }.get(index = 0).name)
        assertEquals("Denver", families.filter { it.vId == 0x4e && it.id == 0x0 }.get(index = 0).name)
        assertEquals("Scorpion", families.filter { it.vId == 0x51 && it.id == 0xf }.get(index = 0).name)
        assertEquals("Scorpion", families.filter { it.vId == 0x51 && it.id == 0x2d }.get(index = 0).name)
        assertEquals("Krait", families.filter { it.vId == 0x51 && it.id == 0x4d }.get(index = 0).name)
        assertEquals("Krait", families.filter { it.vId == 0x51 && it.id == 0x6f }.get(index = 0).name)
        assertEquals("Kryo", families.filter { it.vId == 0x51 && it.id == 0x201 }.get(index = 0).name)
        assertEquals("Kryo", families.filter { it.vId == 0x51 && it.id == 0x205 }.get(index = 0).name)
        assertEquals("Kryo", families.filter { it.vId == 0x51 && it.id == 0x211 }.get(index = 0).name)
        assertEquals("Kryo-2xx", families.filter { it.vId == 0x51 && it.id == 0x800 }.get(index = 0).name)
        assertEquals("Kryo-2xx", families.filter { it.vId == 0x51 && it.id == 0x801 }.get(index = 0).name)
        assertEquals("Kryo-3xx", families.filter { it.vId == 0x51 && it.id == 0x802 }.get(index = 0).name)
        assertEquals("Kryo-3xx", families.filter { it.vId == 0x51 && it.id == 0x803 }.get(index = 0).name)
        assertEquals("Mongoose", families.filter { it.vId == 0x53 && it.id == 0x1 }.get(index = 0).name)
        assertEquals("Mongoose-M3", families.filter { it.vId == 0x53 && it.id == 0x2 }.get(index = 0).name)
        assertEquals("Intel", families.filter { it.vId == 0x69 && it.id == 0x1 }.get(index = 0).name)
    }
}