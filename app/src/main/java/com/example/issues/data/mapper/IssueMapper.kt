package com.example.issues.data.mapper

import com.example.issues.data.api.IssueDto
import com.example.issues.domain.Issue
import javax.inject.Inject

class IssueMapper @Inject constructor() {
    fun toIssue(issueDto: IssueDto) = Issue(
        issueDto.title,
        issueDto.body
    )
}