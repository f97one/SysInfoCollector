package net.formula97.androidapps.sysinfocollector.logic.factory

import net.formula97.androidapps.sysinfocollector.domain.inventory.InventoryCategory

/**
 * Interface that defines the process of injecting inventory from system file.
 *
 * @param T target type of injection
 */
interface SysFileInventoryInjector<T: InventoryCategory> {
    /**
     * Gets inventory from system file.
     *
     * @param filePath target full path of system file
     * @return Inventory object injected from system file
     */
    fun fromSysFile(filePath: String): T
}