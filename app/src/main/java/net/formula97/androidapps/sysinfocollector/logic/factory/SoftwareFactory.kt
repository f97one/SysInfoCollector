package net.formula97.androidapps.sysinfocollector.logic.factory

import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.os.Build
import net.formula97.androidapps.sysinfocollector.domain.inventory.Software
import java.io.File
import java.util.*

class SoftwareFactory: AbstractInventoryBuilder<Software>(), ContextInventoryInjector<Software> {
    override fun fromContext(context: Context): Software {
        throw RuntimeException("Call #listFromContext(Context) instead: Device usually has many apps")
    }

    override fun listFromContext(context: Context): MutableList<Software> {
        val ret = mutableListOf<Software>()

        val pm = context.packageManager
        val appInfoList = pm.getInstalledApplications(PackageManager.GET_META_DATA)
        appInfoList.forEach {
            ret.add(Software().apply {
                name = pm.getApplicationLabel(it).toString()
                from = "Android"
                comments = it.packageName
                version = pm.getPackageInfo(it.packageName, PackageManager.GET_META_DATA).versionName
                fileSize = getPackageSize(pm, it)
                installDate = getFirstInstalled(pm, it)
                folder = getPackageInstalledFolder(pm, it)
                noRemove = isAppRemovable(pm, it)
                userId = it.uid.toString()
                systemCategory = findAppCategory(it, context)
            })
        }

        return ret
    }

    private fun getPackageSize(pm: PackageManager, appInfo: ApplicationInfo): Long {
        // 0 -> flag not specified
        val packageFile = File(pm.getApplicationInfo(appInfo.packageName, 0).publicSourceDir)
        return packageFile.length() / 1000L / 1000L
    }

    private fun getFirstInstalled(pm: PackageManager, appInfo: ApplicationInfo): Date {
        val pi = pm.getPackageInfo(appInfo.packageName, PackageManager.GET_META_DATA)
        return Date(pi.firstInstallTime)
    }

    private fun getPackageInstalledFolder(pm: PackageManager, appInfo: ApplicationInfo): String {
        // 0 -> flag not specified
        val packageFile = File(pm.getApplicationInfo(appInfo.packageName, 0).publicSourceDir)
        return packageFile.absolutePath.substring(0, packageFile.absolutePath.lastIndexOf("/"))
    }

    private fun isAppRemovable(pm: PackageManager, appInfo: ApplicationInfo): Boolean {
        // 0 -> flag not specified
        val packageFile = File(pm.getApplicationInfo(appInfo.packageName, 0).publicSourceDir)
        val absPath = packageFile.absolutePath

        val isVendor = absPath.contains("/system/vendor/operator/")
        val isData = absPath.contains("/data/app/")
        val isSystem = absPath.contains("/system/app/")
        val hasSystemPriv = absPath.contains("/system/priv-app/")
        val isFramework = absPath.contains("/system/framework/")
        val isPlugins = absPath.contains("/system/plugin/")

        return if (isVendor || isData) {
            true
        } else !(isSystem || hasSystemPriv || isFramework || isPlugins)
    }

    private fun findAppCategory(appInfo: ApplicationInfo, context: Context): String {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            ApplicationInfo.getCategoryTitle(context, appInfo.category).toString()
        } else {
            NOT_APPLICABLE
        }
    }
}