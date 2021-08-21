package net.formula97.androidapps.sysinfocollector.domain.inventory

import android.content.Context

/**
 * Interface that defines the process of injecting inventory from Context.
 *
 * @param T target type of injection
 */
interface ContextInventoryInjector<T: InventoryCategory> {
    /**
     * Gets inventory from [Context] .
     *
     * @param context target Context
     * @return Inventory object injected from Context
     */
    fun fromContext(context: Context): T
}