package net.formula97.androidapps.sysinfocollector.logic.converter

import org.junit.Assert.*
import org.junit.Test
import java.lang.NullPointerException
import java.util.*

class StdDateConverterTest {
    @Test
    fun readsDateNormally() {
        val actual = StdDateConverter().read("2021/08/16")
        val c = Calendar.getInstance()
        c.time = actual
        assertEquals(2021, c.get(Calendar.YEAR))
        assertEquals(Calendar.AUGUST, c.get(Calendar.MONTH))
        assertEquals(16, c.get(Calendar.DAY_OF_MONTH))
    }

    @Test
    fun readsDateStringNormally() {
        val c = Calendar.getInstance()
        c.set(Calendar.YEAR, 2021)
        c.set(Calendar.MONTH, Calendar.AUGUST)
        c.set(Calendar.DAY_OF_MONTH, 16)

        val actual = StdDateConverter().write(c.time)
        assertEquals("2021/08/16", actual)
    }

    @Test
    fun throwsNPEWhenArgStringIsNull() {
        try {
            val actual = StdDateConverter().read(null)
            fail("any exceptions was not thrown")
        } catch (e: Exception) {
            assertTrue(e is NullPointerException)
        }
    }

    @Test
    fun returnsEmptyWhenArgDateIsNull() {
        val actual = StdDateConverter().write(null)
        assertEquals("", actual)
    }
}