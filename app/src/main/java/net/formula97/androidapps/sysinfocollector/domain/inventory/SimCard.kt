package net.formula97.androidapps.sysinfocollector.domain.inventory

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "SIMCARDS")
data class SimCard(
    /**
     * IMSI
     */
    @PropertyElement(name = "IMSI", writeAsCData = true)
    var imsi: String? = null,
    /**
     * phone number
     */
    @PropertyElement(name = "PHONE_NUMBER", writeAsCData = true)
    var phoneNumber: String = "",
    /**
     * ICCID (serial number)
     */
    @PropertyElement(name = "ICCID", writeAsCData = true)
    var iccId: String? = null,
    /**
     * State
     */
    @PropertyElement(name = "STATE", writeAsCData = true)
    var state: String? = null,
    /**
     * Country
     */
    @PropertyElement(name = "COUNTRY", writeAsCData = true)
    var country: String? = null,
    /**
     * operator code
     */
    @PropertyElement(name = "OPERATOR_CODE", writeAsCData = true)
    var operatorCode: String? = null,
    /**
     * operator name
     */
    @PropertyElement(name = "OPERATOR_NAME", writeAsCData = true)
    var operatorName: String? = null,
)
