package com.postnow.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://9b629ded-dd45-4df0-bf8c-2b2d0e7c6887.mock.pstmn.io/"
    val apiService: ApiService by lazy { createApiService() }

    private fun createApiService(): ApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(ApiService::class.java)
    }
}
