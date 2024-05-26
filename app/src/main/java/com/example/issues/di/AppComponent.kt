package com.example.issues.di

import com.example.issues.data.di.IssuesDataModule
import com.example.issues.presentation.view.issuesList.FragmentIssuesList
import com.example.issues.presentation.viewModel.IssuesViewModelFactory
import dagger.Component

@Component(modules = [IssuesDataModule::class])
interface AppComponent {
    fun inject(fragment: FragmentIssuesList)
    val viewmodelFactory: IssuesViewModelFactory
}