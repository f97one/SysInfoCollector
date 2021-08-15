package net.formula97.androidapps.sysinfocollector.logic.converter

import com.tickaroo.tikxml.TypeConverter
import net.formula97.androidapps.sysinfocollector.domain.VirtualizationTechnology

class VTConverter: TypeConverter<VirtualizationTechnology> {
    override fun read(value: String?): VirtualizationTechnology {
        return VirtualizationTechnology.valueOf(value!!)
    }

    override fun write(value: VirtualizationTechnology?): String {
        return value!!.systemType
    }
}