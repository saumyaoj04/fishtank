package com.devshiv.fishtankecell.model

import java.io.Serializable

data class InputFieldsData(
    var ID: Int? = 1,
    var Name: String? = "",
    var Type: String? = "text",
    var Input: String? = "",
    var enabled : Boolean = true
) : Serializable
