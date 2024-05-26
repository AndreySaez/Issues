package com.example.issues.domain

import com.example.issues.data.Issue

interface IssuesRepository {
    suspend fun getIssues(): List<Issue>
}