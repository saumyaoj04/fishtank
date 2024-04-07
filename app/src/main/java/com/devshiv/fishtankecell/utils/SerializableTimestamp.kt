package com.devshiv.fishtankecell.utils

import java.io.Serializable
import java.util.*

class SerializableTimestamp(private val timestamp: Date) : Serializable {
    fun toDate(): Date {
        return timestamp
    }
}
