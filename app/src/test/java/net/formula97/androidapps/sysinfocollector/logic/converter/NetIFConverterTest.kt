package net.formula97.androidapps.sysinfocollector.logic.converter

import net.formula97.androidapps.sysinfocollector.domain.NetIFType
import org.junit.Assert.*
import org.junit.Test

class NetIFConverterTest {
    @Test
    fun readsNetIFNormally() {
        val actual = NetIFConverter().read("wifi")
        assertEquals(NetIFType.WiFi, actual)
    }

    @Test
    fun writesNetIFNormally() {
        val actual = NetIFConverter().write(NetIFType.Ethernet)
        assertEquals("ethernet", actual)
    }
}