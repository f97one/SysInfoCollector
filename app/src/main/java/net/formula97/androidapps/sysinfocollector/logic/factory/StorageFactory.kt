package net.formula97.androidapps.sysinfocollector.logic.factory

import android.content.Context
import android.os.StatFs
import androidx.core.content.ContextCompat
import net.formula97.androidapps.sysinfocollector.domain.inventory.Storage
import java.io.File

class StorageFactory: AbstractInventoryBuilder<Storage>(), ContextInventoryInjector<Storage> {
    override fun fromContext(context: Context): Storage {
        // returns internal storage only (index 0)
        return listFromContext(context)[0]
    }

    override fun listFromContext(context: Context): MutableList<Storage> {
        val ret = mutableListOf<Storage>()

        val dirs = ContextCompat.getExternalFilesDirs(context, null)
        dirs.forEach { ret.add(readFromFile(it)) }

        return ret
    }

    private fun readFromFile(file: File): Storage {
        val stat = StatFs(file.path)
        return Storage().apply {
            name = file.name
            type = "disk"
            serial = ""
            diskSize = stat.blockSizeLong / 1000L / 1000L
        }
    }
}