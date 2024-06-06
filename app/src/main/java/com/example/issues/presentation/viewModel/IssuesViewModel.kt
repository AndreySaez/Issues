package com.example.issues.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.issues.domain.Issue
import com.example.issues.domain.IssuesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class IssuesViewModel @Inject constructor(private val issuesRepository: IssuesRepository) :
    ViewModel() {
    private val _issuesList = MutableStateFlow<List<Issue>>(emptyList())
    val issuesList: StateFlow<List<Issue>> = _issuesList.asStateFlow()

    init {
        doRequest()
    }

    private fun doRequest() {
        viewModelScope.launch {
            _issuesList.value = issuesRepository.getIssues()
        }
    }
    fun onRefresh(){
        doRequest()
    }

}