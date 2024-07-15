package com.example.issues.data.api

import okhttp3.Interceptor
import okhttp3.Response

class LoginInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer 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")
            .build()
        return chain.proceed(original)
    }
}