package net.formula97.androidapps.sysinfocollector.logic.converter

import com.tickaroo.tikxml.TypeConverter
import org.apache.commons.codec.binary.Hex
import java.nio.ByteBuffer
import java.util.*

class HexadecimalUuidConverter: TypeConverter<UUID> {
    override fun read(value: String?): UUID {
        val uuidBytes = Hex.decodeHex(value!!.toCharArray())
        val bb = ByteBuffer.wrap(uuidBytes)
        val upper = bb.long
        val lower = bb.long
        return UUID(upper, lower)
    }

    override fun write(value: UUID?): String {
        val bb = ByteBuffer.wrap(ByteArray(16))
        bb.putLong(value!!.mostSignificantBits).putLong(value.leastSignificantBits)
        return String(Hex.encodeHex(bb.array()))
    }
}