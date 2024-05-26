package com.example.issues.data.di

import com.example.issues.data.api.GitHubApiInterface
import com.example.issues.data.repository.IssuesRepositoryImpl
import com.example.issues.domain.IssuesRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(includes = [IssuesDataModule.Declarations::class])
class IssuesDataModule {
    @Provides
    fun apiInterface() = GitHubApiInterface.create()

    @Module
    abstract class Declarations {

        @Binds
        abstract fun bindRepository(issuesRepositoryImpl: IssuesRepositoryImpl): IssuesRepository
    }
}

