package com.example.issues.domain

import com.example.issues.data.Issue
import com.example.issues.data.api.GitHubApiInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class IssuesRepository {
    suspend fun getIssues(): List<Issue> = withContext(Dispatchers.IO) {
        GitHubApiInterface.create().getIssues()
    }
}