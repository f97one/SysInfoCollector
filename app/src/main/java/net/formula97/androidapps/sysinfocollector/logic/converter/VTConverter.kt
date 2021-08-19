package net.formula97.androidapps.sysinfocollector.logic.converter

import com.tickaroo.tikxml.TypeConverter
import net.formula97.androidapps.sysinfocollector.domain.VirtualizationTechnology
import net.formula97.androidapps.sysinfocollector.domain.find

class VTConverter: TypeConverter<VirtualizationTechnology> {
    override fun read(value: String?): VirtualizationTechnology {
        return VirtualizationTechnology::systemType.find(value!!)!!
    }

    override fun write(value: VirtualizationTechnology?): String {
        return value!!.systemType
    }
}