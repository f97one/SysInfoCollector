package net.formula97.androidapps.sysinfocollector.logic.converter

import net.formula97.androidapps.sysinfocollector.domain.CpuArch
import org.junit.Assert.*
import org.junit.Test

class CpuArchConverterTest {
    @Test
    fun readsCpuArchNormally() {
        val actual = CpuArchConverter().read("ARM")
        assertEquals(CpuArch.ARM, actual)
    }

    @Test
    fun writesCpuArchNormally() {
        val actual = CpuArchConverter().write(CpuArch.MIPS64)
        assertEquals("MIPS64", actual)
    }

    @Test
    fun throwsNPEIfArgIsNullWhenRead() {
        try {
            val actual = CpuArchConverter().read(null)
            fail("No exception was thrown, returned $actual")
        } catch (e: Exception) {
            assertTrue(e is NullPointerException)
        }
    }

    @Test
    fun throwsNPEIfArgIsNullWhenWrite() {
        try {
            val actual = CpuArchConverter().write(null)
            fail("No exception was thrown, returned $actual")
        } catch (e: Exception) {
            assertTrue(e is NullPointerException)
        }
    }
}