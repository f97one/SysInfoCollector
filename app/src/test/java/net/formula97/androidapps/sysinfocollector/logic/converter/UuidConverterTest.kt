package net.formula97.androidapps.sysinfocollector.logic.converter

import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.*

class UuidConverterTest {
    @Test
    fun readsUuidStringNormally() {
        val expected = UUID.randomUUID()
        val uuidStr = expected.toString()
        val actual = UuidConverter().read(uuidStr)

        assertEquals(expected, actual)
    }

    @Test
    fun readsUuidNormally() {
        val uuid = UUID.randomUUID()
        val expected = uuid.toString()
        val actual = UuidConverter().write(uuid)

        assertEquals(expected, actual)
    }
}