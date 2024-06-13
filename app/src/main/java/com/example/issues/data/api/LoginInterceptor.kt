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