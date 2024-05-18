package com.example.issues.presentation.view.issuesList

import com.example.issues.data.Issue

fun interface ClickListener {
    fun onCLick(item: Issue)
}