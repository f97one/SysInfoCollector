package net.formula97.androidapps.sysinfocollector.logic.converter

import net.formula97.androidapps.sysinfocollector.domain.VirtualizationTechnology
import org.junit.Assert.*
import org.junit.Test

class VTConverterTest {
    @Test
    fun canTransformFromEnum() {
        val actual = VTConverter().write(VirtualizationTechnology.VirtualMachine)
        assertEquals("Virtual Machine", actual)
    }

    @Test
    fun canTransformFromString() {
        val actual = VTConverter().read("SolarisZone")
        assertEquals(VirtualizationTechnology.SolarisZone, actual)
    }
}

