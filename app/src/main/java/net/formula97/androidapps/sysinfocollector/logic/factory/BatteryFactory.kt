package net.formula97.androidapps.sysinfocollector.logic.factory

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import net.formula97.androidapps.sysinfocollector.domain.inventory.Battery

class BatteryFactory: AbstractInventoryBuilder<Battery>(), ContextInventoryInjector<Battery> {

    override fun fromContext(context: Context): Battery {
        return listFromContext(context)[0]
    }

    override fun listFromContext(context: Context): MutableList<Battery> {
        val batteryIntent = IntentFilter(Intent.ACTION_BATTERY_CHANGED).let { context.registerReceiver(null, it) }

        val ret = mutableListOf<Battery>()
        if (batteryIntent != null) {
            val batt = Battery().apply {
                capacity = getDesignedCapacity(context)
                chemistry = batteryIntent.getStringExtra("technology")
                name = NOT_APPLICABLE
                serial = NOT_APPLICABLE
                manufacturer = NOT_APPLICABLE
                voltage = batteryIntent.getIntExtra(BatteryManager.EXTRA_VOLTAGE, 0)
                realCapacity = getCurrentCapacity(context)
            }
            ret.add(batt)
        }

        return ret
    }

    /**
     * Reads battery capacity.
     *
     * @param context target [Context]
     * @return Capacity recognized by the system(mWh)
     */
    private fun getDesignedCapacity(context: Context): Int {
        val battMgr = context.getSystemService(Context.BATTERY_SERVICE) as BatteryManager

        // Analogize the maximum capacity from the current remaining power and battery capacity [%].
        val pct = battMgr.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY).toFloat() / 100F
        val currentEnergy = getCurrentCapacity(context).toFloat()

        return (currentEnergy / pct).toInt()
    }

    /**
     * Reads current remaining energy.
     *
     * @param context target [Context]
     * @return current remaining energy(mWh)
     */
    private fun getCurrentCapacity(context: Context): Int {
        val battMgr = context.getSystemService(Context.BATTERY_SERVICE) as BatteryManager

        // unit of current energy is nanowatt-hours
        val energy = battMgr.getLongProperty(BatteryManager.BATTERY_PROPERTY_ENERGY_COUNTER)
        return (energy.toDouble() / 1000000).toInt()
    }
}