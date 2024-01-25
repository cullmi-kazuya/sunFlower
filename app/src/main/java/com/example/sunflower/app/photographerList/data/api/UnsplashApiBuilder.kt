package com.example.sunflower.app.photographerList.data.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UnsplashApiBuilder {

    private val BASE_URL = "https://api.unsplash.com/"
    private val ACCESS_KEY = "7GoX_akpiaemk7T4mP66Srb1h3ROisIR-RFxSuMg3Wk"

    fun buildApiService(): UnsplashApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(
                OkHttpClient
                    .Builder()
                    .addInterceptor(UnsplashInterceptor(ACCESS_KEY)).build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(UnsplashApi::class.java)
    }
}