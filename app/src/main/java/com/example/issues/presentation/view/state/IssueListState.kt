package com.example.issues.presentation.view.state

import com.example.issues.domain.Issue

sealed class IssueListState {
    data class IssueList(val items: List<Issue>) : IssueListState()
    data object Loading : IssueListState()
    data object Empty : IssueListState()
    data object Error : IssueListState()
}