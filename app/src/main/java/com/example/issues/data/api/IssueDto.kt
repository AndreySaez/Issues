package com.example.issues.data.api

import com.google.gson.annotations.SerializedName

data class IssueDto(
    @SerializedName("title") val title: String,
    @SerializedName("body") val body: String?,
    @SerializedName("id") val id: Long,
    @SerializedName("node_id") val nodeId: String
)
