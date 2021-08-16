package net.formula97.androidapps.sysinfocollector.domain

enum class CpuArch(val archType: String) {
    /**
     * MIPS architecture
     */
    MIPS("MIPS"),

    /**
     * MIPS 64 architecture
     */
    MIPS64("MIPS64"),

    /**
     * DEC Alpha architecture
     */
    ALPHA("Alpha"),

    /**
     * SUN SPARC architecture
     */
    SPARC("SPARC"),

    /**
     * SUN SPARC 64bit architecture
     */
    SPARC64("SPARC64"),

    /**
     * MC68000 architecture
     */
    M68K("m68k"),

    /**
     * Intel x86 architecture
     */
    I386("i386"),

    /**
     * Intel x86_64(a.k.a. AMD64) architecture
     */
    X86_64("x86_64"),

    /**
     * PowerPC architecture
     */
    POWER_PC("PowerPC"),

    /**
     * PowerPC 64 architecture
     */
    POWER_PC64("PowerPC64"),

    /**
     * ARM 32bit architecture
     */
    ARM("ARM"),

    /**
     * ARM 64bit architecture
     */
    A_ARCH64("AArch64")
}