package net.formula97.androidapps.sysinfocollector.logic.converter

import com.tickaroo.tikxml.TypeConverter
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class StdDateTimeConverter: TypeConverter<Date> {

    companion object {
        private const val dateFormat: String = "yyyy-MM-dd HH:mm:ss"
    }

    override fun read(value: String?): Date {
        val df: DateFormat = SimpleDateFormat(dateFormat, Locale.getDefault())
        return df.parse(value!!)
    }

    override fun write(value: Date?): String {
        val df: DateFormat = SimpleDateFormat(dateFormat, Locale.getDefault())
        return df.format(value!!)
    }
}