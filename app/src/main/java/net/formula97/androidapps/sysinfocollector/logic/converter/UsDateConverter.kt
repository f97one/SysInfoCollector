package net.formula97.androidapps.sysinfocollector.logic.converter

import com.tickaroo.tikxml.TypeConverter
import java.text.SimpleDateFormat
import java.util.*

class UsDateConverter: TypeConverter<Date> {

    companion object {
        private const val dateFormat: String = "dd/MM/yyyy"
    }

    override fun read(value: String?): Date {
        val df = SimpleDateFormat(dateFormat, Locale.getDefault())
        return df.parse(value!!)!!
    }

    override fun write(value: Date?): String {
        val df = SimpleDateFormat(dateFormat, Locale.getDefault())
        return df.format(value!!)
    }
}