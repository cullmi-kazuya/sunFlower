package com.example.sunflower.app.photoList.data.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UnsplashApiBuilder {
    companion object {
        private val BASE_URL = "https://api.unsplash.com/"
        private val ACCESS_KEY = "7GoX_akpiaemk7T4mP66Srb1h3ROisIR-RFxSuMg3Wk"

        fun create(): UnsplashApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(
                    OkHttpClient
                        .Builder()
                        .addInterceptor(UnsplashInterceptor(ACCESS_KEY)).build()
                )
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(UnsplashApiService::class.java)
        }
    }
}