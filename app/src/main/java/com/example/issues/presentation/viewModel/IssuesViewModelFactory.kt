package com.example.issues.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.issues.domain.IssuesRepository
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class IssuesViewModelFactory @Inject constructor(
    private val repository: IssuesRepository,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return IssuesViewModel(repository) as T
    }
}