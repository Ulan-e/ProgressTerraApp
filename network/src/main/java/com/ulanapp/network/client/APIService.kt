package com.ulanapp.network.client

import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface APIService {

    companion object {
        private const val ACCESS_TOKEN = "api/v3/clients/accesstoken"
        private const val GENERAL_INFO = "/api/v3/ibonus/generalinfo"
    }

    // метод для логина
    @POST(ACCESS_TOKEN)
    suspend fun doAccessToken(): Any

    // метод для получения списка платежей
    @GET(GENERAL_INFO)
    suspend fun getGeneralInfo(@Query("AccessToken") accessToken: String): Any
}