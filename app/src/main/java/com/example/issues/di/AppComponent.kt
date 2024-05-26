package com.example.issues.di

import com.example.issues.data.di.IssuesDataModule
import com.example.issues.presentation.di.IssuesPresentationModule
import com.example.issues.presentation.view.issuesList.FragmentIssuesList
import dagger.Component

@Component(
    modules = [
        IssuesDataModule::class,
        IssuesPresentationModule::class
    ]
)
interface AppComponent {
    fun inject(fragment: FragmentIssuesList)
}