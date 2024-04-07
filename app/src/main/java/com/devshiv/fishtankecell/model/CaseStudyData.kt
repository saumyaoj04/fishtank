package com.devshiv.fishtankecell.model

import com.devshiv.fishtankecell.utils.SerializableTimestamp
import com.google.firebase.Timestamp
import java.io.Serializable

data class CaseStudyData(
    var Title: String? = "",
    var Banner: String? = "",
    var Description: String? = "",
    var StartDate: SerializableTimestamp? = null,
    var EndDate: SerializableTimestamp? = null
) : Serializable
