package net.formula97.androidapps.sysinfocollector.logic.converter

import com.tickaroo.tikxml.TypeConverter

class BoolToIntConverter: TypeConverter<Boolean> {
    override fun read(value: String?): Boolean {
        if (value == null) return false

        return value.toInt() == 1
    }

    override fun write(value: Boolean?): String {
        if (value == null) return "0"

        return if (value) "1" else "0"
    }
}