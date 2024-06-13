package com.example.issues.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.issues.domain.IssuesRepository
import com.example.issues.presentation.view.state.IssueListState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class IssuesViewModel @Inject constructor(private val issuesRepository: IssuesRepository) :
    ViewModel() {
    private val _issuesList = MutableStateFlow<IssueListState>(IssueListState.Empty)
    val issuesList: StateFlow<IssueListState> = _issuesList.asStateFlow()

    init {
        doRequest()
    }

    private fun doRequest() {
        viewModelScope.launch {
            _issuesList.value = IssueListState.Loading
            val items = issuesRepository.getIssues()
            _issuesList.value = if (items.isNotEmpty()) {
                IssueListState.IssueList(items)
            } else {
                IssueListState.Empty
            }
        }
    }

    fun onRefresh() {
        doRequest()
    }
}