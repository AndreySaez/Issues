package com.example.issues.domain

interface IssuesRepository {
    suspend fun getIssues(): List<Issue>
}