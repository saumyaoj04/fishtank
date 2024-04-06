package com.devshiv.fishtankecell.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RegistrationData(

    @SerialName("Status")
    var status: String? = "NONE",
    @SerialName("Admin Name")
    var admin_name: String? = "",
    @SerialName("Admin Email")
    var admin_email: String? = "",
    @SerialName("Date")
    var date: String? = "",
    @SerialName("Event")
    var event: String? = "",

    var extras: HashMap<String,String?>? = null
)
