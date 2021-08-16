package net.formula97.androidapps.sysinfocollector.logic.converter

import com.tickaroo.tikxml.TypeConverter
import net.formula97.androidapps.sysinfocollector.domain.CpuArch

class CpuArchConverter: TypeConverter<CpuArch> {
    override fun read(value: String?): CpuArch {
        return CpuArch.valueOf(value!!)
    }

    override fun write(value: CpuArch?): String {
        return value!!.archType
    }
}