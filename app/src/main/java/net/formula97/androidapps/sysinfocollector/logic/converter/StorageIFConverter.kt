package net.formula97.androidapps.sysinfocollector.logic.converter

import com.tickaroo.tikxml.TypeConverter
import net.formula97.androidapps.sysinfocollector.domain.StorageIFType
import net.formula97.androidapps.sysinfocollector.domain.find

class StorageIFConverter: TypeConverter<StorageIFType> {
    override fun read(value: String?): StorageIFType {
        return StorageIFType::typeName.find(value!!)!!
    }

    override fun write(value: StorageIFType?): String {
        return value!!.typeName
    }
}