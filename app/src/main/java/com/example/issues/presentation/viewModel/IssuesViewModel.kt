package com.example.issues.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.issues.domain.Issue
import com.example.issues.domain.IssuesRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class IssuesViewModel @Inject constructor(issuesRepository: IssuesRepository) : ViewModel() {
    val issuesList: LiveData<List<Issue>> get() = _issuesList
    private val _issuesList = MutableLiveData<List<Issue>>()

    init {
        viewModelScope.launch {
            _issuesList.value = issuesRepository.getIssues()
        }
    }
}