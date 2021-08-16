package net.formula97.androidapps.sysinfocollector.logic.converter

import com.tickaroo.tikxml.TypeConverter
import java.text.SimpleDateFormat
import java.util.*

class StdDateConverter: TypeConverter<Date> {

    companion object {
        private const val stdDateFormat: String = "yyyy/MM/dd"
    }

    override fun read(value: String?): Date {
        val df = SimpleDateFormat(stdDateFormat, Locale.getDefault())
        return df.parse(value!!)!!
    }

    override fun write(value: Date?): String {
        if (value == null) {
            return ""
        }

        val df = SimpleDateFormat(stdDateFormat, Locale.getDefault())
        return df.format(value)
    }
}