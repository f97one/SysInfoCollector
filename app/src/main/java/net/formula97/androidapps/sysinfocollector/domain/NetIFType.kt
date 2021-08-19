package net.formula97.androidapps.sysinfocollector.domain

enum class NetIFType(val ifName: String) {
    Ethernet("ethernet"),
    WiFi("wifi"),
    InfiniBand("infiniband"),
    Aggregate("aggregate"),
    Alias("alias"),
    DialUp("dialup"),
    Loopback("loopback"),
    Bridge("bridge"),
    FibreChannel("fibrechannel")
}
