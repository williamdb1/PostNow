package com.postnow.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PostEntity(
    val title: String,
    val date: String,
    val description: String
): Parcelable