package com.example.issues.presentation.di

import androidx.lifecycle.ViewModel
import com.example.issues.presentation.viewModel.IssuesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet

@Module
interface IssuesPresentationModule {

    @Binds
    @IntoSet
    fun bindIssuesViewModel(issuesViewModel: IssuesViewModel): ViewModel
}