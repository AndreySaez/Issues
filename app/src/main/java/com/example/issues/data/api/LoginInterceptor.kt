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