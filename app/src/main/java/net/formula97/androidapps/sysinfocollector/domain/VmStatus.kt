package net.formula97.androidapps.sysinfocollector.domain

enum class VmStatus(val status: String) {
    RUNNING("running"),
    BLOCKED("blocked"),
    IDLE("idle"),
    PAUSED("paused"),
    SHUTDOWN("shutdown"),
    CRASHED("crashed"),
    DYING("dying"),
    OFF("off")
}