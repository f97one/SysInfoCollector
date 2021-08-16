package net.formula97.androidapps.sysinfocollector.logic.converter

import com.tickaroo.tikxml.TypeConverter
import java.util.*

class UuidConverter: TypeConverter<UUID> {
    override fun read(value: String?): UUID {
        return UUID.fromString(value!!)
    }

    override fun write(value: UUID?): String {
        return value!!.toString()
    }
}