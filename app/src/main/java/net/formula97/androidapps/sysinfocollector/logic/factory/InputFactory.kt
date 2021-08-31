package net.formula97.androidapps.sysinfocollector.logic.factory

import android.content.Context
import android.content.res.Configuration
import net.formula97.androidapps.sysinfocollector.domain.inventory.Input

class InputFactory: AbstractInventoryBuilder<Input>(), ContextInventoryInjector<Input> {
    override fun fromContext(context: Context): Input {
        return if (listFromContext(context).size > 0) listFromContext(context)[0] else Input()
    }

    override fun listFromContext(context: Context): MutableList<Input> {
        val conf = context.resources.configuration
        val ret = mutableListOf<Input>()
        if (conf.touchscreen == Configuration.TOUCHSCREEN_FINGER) {
            ret.add(Input().apply {
                caption = "Touch Screen"
                description = "Touch Screen"
                type = findTouchMethod(conf)
            })
        }

        if (conf.keyboard == Configuration.KEYBOARD_QWERTY || conf.keyboard == Configuration.KEYBOARD_12KEY) {
            ret.add(Input().apply {
                caption = "Keyboard"
                description = "Keyboard"
                type = findKeyboard(conf)
            })
        }

        return ret
    }

    private fun findKeyboard(conf: Configuration): String {
        return when(conf.keyboard) {
            Configuration.KEYBOARD_QWERTY -> "QWERTY layout keyboard"
            Configuration.KEYBOARD_12KEY -> "12KEY layout keyboard"
            Configuration.KEYBOARD_NOKEYS -> "no keys"
            else -> NOT_APPLICABLE
        }
    }

    private fun findTouchMethod(conf: Configuration): String {
        return when(conf.touchscreen) {
            Configuration.TOUCHSCREEN_FINGER -> "Finger"
            Configuration.TOUCHSCREEN_NOTOUCH -> "no touchscreen"
            else -> NOT_APPLICABLE
        }
    }
}