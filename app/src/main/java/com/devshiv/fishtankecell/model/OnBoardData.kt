package com.devshiv.fishtankecell.model

import android.graphics.drawable.Drawable
import com.google.firebase.Timestamp

data class OnBoardData(
    var image: Drawable? = null,
    var headline: String? = "",
    var description: String? = "",
)
