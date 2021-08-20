package net.formula97.androidapps.sysinfocollector.logic.converter

import org.junit.Assert.*
import org.junit.Test
import java.lang.NullPointerException

class YesNoConverterTest {
    @Test
    fun readsYesNormally() {
        val actual = YesNoConverter().read("Yes")
        assertTrue(actual)
    }

    @Test
    fun readsNoNormally() {
        val actual = YesNoConverter().read("No")
        assertFalse(actual)
    }

    @Test
    fun returnsFalseIfNullPassedWhenRead() {
        val actual = YesNoConverter().read(null)
        assertFalse(actual)
    }

    @Test
    fun writesYesNormally() {
        val actual = YesNoConverter().write(true)
        assertEquals("Yes", actual)
    }

    @Test
    fun writesNoNormally() {
        val actual = YesNoConverter().write(false)
        assertEquals("No", actual)
    }

    @Test
    fun throwsNPEIfNullPassedWhenWrite() {
        try {
            val actual = YesNoConverter().write(null)
            fail("Exception not thrown, returned value: $actual")
        } catch (e: Exception) {
            assertTrue(e is NullPointerException)
        }
    }
}