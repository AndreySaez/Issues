package com.example.issues.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Issue(
    val title: String,
    val body: String?,
    val id: Long,
    val nodeId: String
) : Parcelable
