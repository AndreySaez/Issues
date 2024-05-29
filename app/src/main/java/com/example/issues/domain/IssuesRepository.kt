package com.example.issues.domain

import retrofit2.http.Query

interface IssuesRepository {
    suspend fun getIssues(): List<Issue>
}