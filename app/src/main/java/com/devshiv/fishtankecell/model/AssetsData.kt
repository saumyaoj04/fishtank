package com.devshiv.fishtankecell.model

import java.io.Serializable

data class AssetsData(
    var Image: String? = "",
    var Name: String? = "",
    var Price: String = "0",
) : Serializable
