package net.formula97.androidapps.sysinfocollector.logic.converter

import org.junit.Assert.*
import org.junit.Test

class BoolToIntConverterTest {
    @Test
    fun converts1ToBoolTrue() {
        val actual = BoolToIntConverter().read("1")
        assertTrue(actual)
    }

    @Test
    fun convertsToBoolFalse() {
        var actual = BoolToIntConverter().read("0")
        assertFalse(actual)

        actual = BoolToIntConverter().read("2")
        assertFalse(actual)
    }

    @Test
    fun convertsFromBoolTrue() {
        val actual = BoolToIntConverter().write(true)
        assertEquals("1", actual)
    }

    @Test
    fun convertsFromBoolFalse() {
        val actual = BoolToIntConverter().write(false)
        assertEquals("0", actual)
    }

    @Test
    fun returnsFalseIfNullPassedWhenRead() {
        val actual = BoolToIntConverter().read(null)
        assertFalse(actual)
    }

    @Test
    fun returnsZeroIfNullPassedWhenWrite() {
        val actual = BoolToIntConverter().write(null)
        assertEquals("0", actual)
    }
}