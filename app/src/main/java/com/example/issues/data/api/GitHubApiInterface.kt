package com.example.issues.data.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

// https://api.github.com/repos/AndreySaez/Issues/issues
// https://api.github.com/repos/OWNER/REPO/issues
//https://api.github.com/search/issues?q=is:issue%20repo:AndreySaez/Issues
interface GitHubApiInterface {
    @GET("/search/issues")
    @Headers(
        "Accept: application/vnd.github.raw+json",
        "X-GitHub-Api-Version: 2022-11-28"
    )
    suspend fun getIssues(
        @Query("q") isIssue: String = "is:issue repo:AndreySaez/Issues"
    ): IssueResponseDto

    companion object {
        private const val BASE_URL = "https://api.github.com/"
        fun create(): GitHubApiInterface {
            val client = OkHttpClient.Builder()
                .addInterceptor(LoginInterceptor())
                .build()
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .baseUrl(BASE_URL)
                .build()
            return retrofit
                .create(GitHubApiInterface::class.java)

        }
    }
}