package net.formula97.androidapps.sysinfocollector.logic.converter

import net.formula97.androidapps.sysinfocollector.domain.VmStatus
import org.junit.Assert.*
import org.junit.Test

class VmStatusConverterTest {
    @Test
    fun readsVmStatusNormally() {
        val actual = VmStatusConverter().read("shutdown")
        assertEquals(VmStatus.SHUTDOWN, actual)
    }

    @Test
    fun writesVmStatusNormally() {
        val actual = VmStatusConverter().write(VmStatus.RUNNING)
        assertEquals("running", actual)
    }
}