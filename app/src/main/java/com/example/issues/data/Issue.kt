package com.example.issues.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Issue(
    val title: String,
    val body: String?
) : Parcelable
