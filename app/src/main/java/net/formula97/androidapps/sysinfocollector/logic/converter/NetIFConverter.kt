package net.formula97.androidapps.sysinfocollector.logic.converter

import com.tickaroo.tikxml.TypeConverter
import net.formula97.androidapps.sysinfocollector.domain.NetIFType
import net.formula97.androidapps.sysinfocollector.domain.find

class NetIFConverter: TypeConverter<NetIFType> {
    override fun read(value: String?): NetIFType {
        return NetIFType::ifName.find(value!!)!!
    }

    override fun write(value: NetIFType?): String {
        return value!!.ifName
    }
}