package com.example.issues.data.api

import com.example.issues.data.Issue
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

// key: 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
// https://api.github.com/repos/AndreySaez/Issues/issues
// https://api.github.com/repos/OWNER/REPO/issues
interface GitHubApiInterface {
    @GET("/repos/AndreySaez/Issues/issues")
    @Headers(
        "Accept: application/vnd.github.raw+json",
        "Authorization: Bearer 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",
        "X-GitHub-Api-Version: 2022-11-28"
    )
    suspend fun getIssues(): List<Issue>

    companion object {
        private const val BASE_URL = "https://api.github.com/"
        fun create(): GitHubApiInterface {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(GitHubApiInterface::class.java)

        }
    }
}