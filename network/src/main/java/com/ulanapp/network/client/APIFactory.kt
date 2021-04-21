package com.ulanapp.network.client

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object APIFactory {

    private const val BASE_URL = "https://mp1.iprobonus.com/"
    private const val ACCESS_KEY = "891cf53c-01fc-4d74-a14c-592668b7a03c"

    fun create(): APIService {

        val httpclient = OkHttpClient.Builder()
        httpclient.apply {
            readTimeout(30, TimeUnit.SECONDS)
            connectTimeout(30, TimeUnit.SECONDS)
            addInterceptor(Interceptor { chain ->
                val request = chain.request()
                    .newBuilder()
                    .addHeader("AccessKey", ACCESS_KEY)
                    .build()
                chain.proceed(request)
            })
        }

        val retrofit = Retrofit.Builder()
            .client(httpclient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
        return retrofit.create(APIService::class.java);
    }
}