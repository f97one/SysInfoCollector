package net.formula97.androidapps.sysinfocollector.logic.converter

import org.apache.commons.codec.binary.Hex
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import java.util.*

class HexadecimalUuidConverterTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun verifyUUIDBytesCanBeReconstructedBackToOriginalUUID() {
        val u1 = UUID.randomUUID()
        val u1Str = HexadecimalUuidConverter().write(u1)
        val u2 = HexadecimalUuidConverter().read(u1Str)
        assertEquals(u1, u2)
    }

    @Test
    fun verifyNameUUIDFromBytesMethodDoesNotRecreateOriginalUUID() {
        val u1 = UUID.randomUUID()
        val u1Str = HexadecimalUuidConverter().write(u1)
        val u2 = UUID.nameUUIDFromBytes(Hex.decodeHex(u1Str.toCharArray()))
        assertNotEquals(u1, u2)
    }
}