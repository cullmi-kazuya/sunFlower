package com.example.sunflower.app.photographerList.data.api

import okhttp3.Interceptor
import okhttp3.Response

class UnsplashInterceptor(
    private val accessKey: String
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain
            .request()
            .newBuilder()
            .addHeader("Authorization", accessKey)
            .build()
        return chain.proceed(request)
    }
}