package net.formula97.androidapps.sysinfocollector.logic.factory

import android.content.Context

abstract class AbstractInventoryBuilder<T> {

    companion object {
        const val NOT_APPLICABLE:String = "N/A"
    }

    fun throwIfNotHasFeature(context: Context, feature: String) {
        if (!context.packageManager.hasSystemFeature(feature)) {
            throw IllegalStateException("This device has no feature: $feature")
        }
    }
}