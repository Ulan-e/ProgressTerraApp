package com.ulanapp.network.actions

import com.ulanapp.network.responses.AccessTokenResponse
import com.ulanapp.network.responses.RequestBody

interface APIAccessTokenActions {

    // получение токена
    suspend fun getToken(requestBody: RequestBody) : AccessTokenResponse
}