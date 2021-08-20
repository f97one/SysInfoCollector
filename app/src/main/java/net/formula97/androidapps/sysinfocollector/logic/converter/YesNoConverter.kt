package net.formula97.androidapps.sysinfocollector.logic.converter

import com.tickaroo.tikxml.TypeConverter
import java.util.*

class YesNoConverter: TypeConverter<Boolean> {
    override fun read(value: String?): Boolean {
        if (value == null) return false

        return value.lowercase(Locale.getDefault()) == "yes"
    }

    override fun write(value: Boolean?): String {
        return if (value!!) "Yes" else "No"
    }
}