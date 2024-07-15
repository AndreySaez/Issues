package com.example.issues.presentation.view.navigation

import com.example.issues.domain.Issue
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

object Navigator {
    val state get() = _state.asStateFlow()
    private val _state = MutableStateFlow(NavigationState.DEFAULT)
    fun openDetails(details: Issue) {
        _state.tryEmit(NavigationState(details))
    }

    fun closeDetails() {
        _state.tryEmit(NavigationState.DEFAULT)
    }
}

data class NavigationState(val details: Issue? = null) {
    companion object {
        val DEFAULT = NavigationState()
    }
}