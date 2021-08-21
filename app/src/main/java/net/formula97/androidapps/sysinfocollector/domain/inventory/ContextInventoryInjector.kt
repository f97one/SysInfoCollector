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
     * @return Inventory object injected from Context, if device has multiple inventory, returns first one
     */
    fun fromContext(context: Context): T

    /**
     * Gets inventory as List from [Context] .
     *
     * @param context target context
     * @return List of Inventory objects from Context
     */
    fun listFromContext(context: Context): MutableList<T>
}