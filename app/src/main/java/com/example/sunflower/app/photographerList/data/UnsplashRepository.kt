package com.example.sunflower.app.photographerList.data

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UnsplashRepository {
    private val BASE_URL = "https://api.unsplash.com/"
    private val ACCESS_KEY = "7GoX_akpiaemk7T4mP66Srb1h3ROisIR-RFxSuMg3Wk"

    fun create() {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient.Builder().addInterceptor(UnsplashInterceptor(ACCESS_KEY)).build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api: UnsplashService = retrofit.create(UnsplashService::class.java)
    }
}

class UnsplashInterceptor(
    private val accessKey: String
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain
            .request()
            .newBuilder()
            .addHeader("Authorization", "Client-ID $accessKey")
            .build()
        return chain.proceed(request)
    }
}