package com.ulanapp.network.client

import com.ulanapp.network.responses.AccessTokenResponse
import com.ulanapp.network.responses.BonusInfoResponse
import com.ulanapp.network.responses.RequestBody
import retrofit2.http.*

interface APIService {

    companion object {
        private const val ACCESS_TOKEN = "api/v3/clients/accesstoken"
        private const val GENERAL_INFO = "api/v3/ibonus/generalinfo/{AccessToken}"
    }

    // метод для логина
    @POST(ACCESS_TOKEN)
    suspend fun getAccessToken(@Body requestBody: RequestBody): AccessTokenResponse

    // метод для получения списка платежей
    @GET(GENERAL_INFO)
    suspend fun getGeneralInfo(@Path("AccessToken") accessToken: String): BonusInfoResponse
}