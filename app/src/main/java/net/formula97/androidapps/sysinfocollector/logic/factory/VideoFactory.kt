package net.formula97.androidapps.sysinfocollector.logic.factory

import android.content.Context
import android.graphics.Point
import android.os.Build
import android.view.WindowManager
import net.formula97.androidapps.sysinfocollector.domain.inventory.Video
import timber.log.Timber

class VideoFactory: AbstractInventoryBuilder<Video>(), ContextInventoryInjector<Video> {
    override fun fromContext(context: Context): Video {
        return Video().apply {
            name = NOT_APPLICABLE
            resolution = getCurrentResolution(context)
        }
    }

    override fun listFromContext(context: Context): MutableList<Video> {
        return mutableListOf(fromContext(context))
    }

    private fun getCurrentResolution(context: Context): String {
        val windowMgr = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        return try {
            val point = Point()

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                val maxBounds = windowMgr.maximumWindowMetrics.bounds
                point.x = maxBounds.width()
                point.y = maxBounds.height()
            } else {
                windowMgr.defaultDisplay!!.getSize(point)
            }

            "${point.x}x${point.y}"
        } catch (e: Exception) {
            Timber.e(e)
            NOT_APPLICABLE
        }
    }
}