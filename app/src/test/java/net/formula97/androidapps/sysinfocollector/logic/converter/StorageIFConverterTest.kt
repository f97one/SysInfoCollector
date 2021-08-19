package net.formula97.androidapps.sysinfocollector.logic.converter

import net.formula97.androidapps.sysinfocollector.domain.StorageIFType
import org.junit.Assert.*
import org.junit.Test

class StorageIFConverterTest {
    @Test
    fun readsIFTypeNormally() {
        val actual = StorageIFConverter().read("serial-ATA")
        assertEquals(StorageIFType.SerialATA, actual)
    }

    @Test
    fun writesIFTypeNormally() {
        val actual = StorageIFConverter().write(StorageIFType.IEEE1394)
        assertEquals("1394", actual)
    }
}