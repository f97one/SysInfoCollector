package net.formula97.androidapps.sysinfocollector.domain

enum class StorageIFType(val typeName: String) {
    SCSI("SCSI"),
    HDC("HDC"),
    IDE("IDE"),
    USB("USB"),
    IEEE1394("1394"),
    SerialATA("serial-ATA"),
    SAS("SAS")
}