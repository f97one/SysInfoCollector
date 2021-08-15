package net.formula97.androidapps.sysinfocollector.domain

enum class VirtualizationTechnology(val systemType: String) {
    Physical("Physical"),
    Xen("Xen"),
    VirtualBox("VirtualBox"),
    VirtualMachine("Virtual Machine"),
    VMware("VMware"),
    QEMU("QEMU"),
    SolarisZone("SolarisZone"),
    VServer("VServer"),
    OpenVZ("OpenVZ"),
    BSDJail("BSDJail"),
    Parallels("Parallels"),
    HyperV("Hyper-V"),
    AIX_LPAR("AIX_LPAR")
}