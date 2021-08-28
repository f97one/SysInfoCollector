package net.formula97.androidapps.sysinfocollector.logic.factory

import android.content.Context
import android.net.ConnectivityManager
import android.net.LinkProperties
import android.net.NetworkCapabilities
import android.net.wifi.WifiInfo
import android.net.wifi.WifiManager
import android.os.Build
import android.system.OsConstants
import net.formula97.androidapps.sysinfocollector.domain.NetIFType
import net.formula97.androidapps.sysinfocollector.domain.inventory.Network
import org.apache.commons.net.util.SubnetUtils
import java.math.BigInteger
import java.net.Inet4Address
import java.net.Inet6Address
import java.net.InetAddress

class NetworkFactory: AbstractInventoryBuilder<Network>(), ContextInventoryInjector<Network> {
    override fun fromContext(context: Context): Network {
        val l = listFromContext(context)
        return if (l.isEmpty()) Network() else l[0]
    }

    override fun listFromContext(context: Context): MutableList<Network> {
        val wifiMgr = context.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
        val connMgr = context.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val currentNetwork = connMgr.activeNetwork
        val caps = connMgr.getNetworkCapabilities(currentNetwork)
        val linkProp = connMgr.getLinkProperties(currentNetwork)

        if (!wifiMgr.isWifiEnabled) {
            // abort to read network state
            return mutableListOf(Network(status = "down", driver = "WIFI", type = NetIFType.WiFi))
        }

        return mutableListOf(Network().apply {
            driver = "WIFI"
            type = NetIFType.WiFi
            ipAddress = getIpv4Address(linkProp!!)
            ipSubnet = getIpv4Subnet(linkProp)
            ipMask = getIpv4Mask(linkProp)
            ipAddress6 = getIpv6Address(linkProp)
            ipDhcp = getDhcpServerAddr(wifiMgr, linkProp)
            wifiSsid = getSsid(caps!!)
            wifiBssid = getBSsid(caps)
        })
    }

    private fun getIpv4Address(linkProp: LinkProperties): String {
        val addr = linkProp.linkAddresses.first { it.scope == OsConstants.RT_SCOPE_HOST }.address as Inet4Address
        return addr.hostAddress ?: NOT_APPLICABLE
    }

    private fun readSubnetInfo(linkProp: LinkProperties): SubnetUtils.SubnetInfo? {
        val linkAddr = linkProp.linkAddresses.first { it.scope == OsConstants.RT_SCOPE_HOST }
        val prefix = linkAddr.prefixLength

        val ipAddr = getIpv4Address(linkProp)
        if (ipAddr == NOT_APPLICABLE) return null
        return SubnetUtils("${ipAddr}/${prefix}").info
    }

    private fun getIpv4Subnet(linkProp: LinkProperties): String {
        val linkAddr = linkProp.linkAddresses.first { it.scope == OsConstants.RT_SCOPE_HOST }
        val prefix = linkAddr.prefixLength

        val ipAddr = getIpv4Address(linkProp)
        if (ipAddr == NOT_APPLICABLE) return NOT_APPLICABLE

        val subnetInfo = SubnetUtils("${ipAddr}/${prefix}").info
        return "${subnetInfo.networkAddress}/${prefix}"
    }

    private fun getIpv4Mask(linkProp: LinkProperties): String {
        val subnetInfo = readSubnetInfo(linkProp) ?: return NOT_APPLICABLE
        return subnetInfo.netmask
    }

    private fun getIpv6Address(linkProp: LinkProperties): String {
        val addr = linkProp.linkAddresses.first { it.scope == OsConstants.RT_SCOPE_HOST }.address as Inet6Address
        return addr.hostAddress ?: NOT_APPLICABLE
    }

    private fun getDhcpServerAddr(wifiMgr: WifiManager, linkProp: LinkProperties): String {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            linkProp.dhcpServerAddress?.hostAddress ?: NOT_APPLICABLE
        } else {
            val dhcpInt = wifiMgr.dhcpInfo.ipAddress
            val b = BigInteger.valueOf(dhcpInt.toLong()).toByteArray()
            InetAddress.getByAddress(b).hostAddress ?: NOT_APPLICABLE
        }
    }

    private fun getSsid(caps: NetworkCapabilities): String {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val wifiInfo = caps.transportInfo as WifiInfo
            wifiInfo.ssid
        } else {
            NOT_APPLICABLE
        }
    }

    private fun getBSsid(caps: NetworkCapabilities): String {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val wifiInfo = caps.transportInfo as WifiInfo
            wifiInfo.bssid
        } else {
            NOT_APPLICABLE
        }
    }


    private fun getGatewayAddr(): String? {
        TODO()
    }
}