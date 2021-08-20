package net.formula97.androidapps.sysinfocollector.logic.converter

import com.tickaroo.tikxml.TypeConverter
import net.formula97.androidapps.sysinfocollector.domain.VmStatus
import net.formula97.androidapps.sysinfocollector.domain.find

class VmStatusConverter: TypeConverter<VmStatus> {
    override fun read(value: String?): VmStatus {
        return VmStatus::status.find(value!!)!!
    }

    override fun write(value: VmStatus?): String {
        return value!!.status
    }
}