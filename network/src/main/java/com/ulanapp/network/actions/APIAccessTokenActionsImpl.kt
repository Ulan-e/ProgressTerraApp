package com.ulanapp.network.actions

import com.ulanapp.network.client.APIFactory
import com.ulanapp.network.responses.AccessTokenResponse
import com.ulanapp.network.responses.RequestBody
import javax.inject.Inject

class APIAccessTokenActionsImpl @Inject constructor() : APIAccessTokenActions {

    override suspend fun getToken(requestBody: RequestBody): AccessTokenResponse {
        return APIFactory.create().getAccessToken(requestBody)
    }
}