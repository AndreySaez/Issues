package com.example.issues.data.repository

import com.example.issues.data.api.GitHubApiInterface
import com.example.issues.data.mapper.IssueMapper
import com.example.issues.domain.Issue
import com.example.issues.domain.IssuesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class IssuesRepositoryImpl @Inject constructor(
    private val apiInterface: GitHubApiInterface,
    private val mapper: IssueMapper,
) : IssuesRepository {
    override suspend fun getIssues(): List<Issue> = withContext(Dispatchers.IO) {
        apiInterface.getIssues().items.map(mapper::toIssue)
    }
}