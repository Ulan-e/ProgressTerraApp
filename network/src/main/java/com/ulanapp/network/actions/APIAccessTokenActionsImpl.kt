package com.ulanapp.network.actions

import com.ulanapp.network.client.APIFactory
import com.ulanapp.network.responses.AccessTokenResponse

class APIAccessTokenActionsImpl : APIAccessTokenActions {

    override suspend fun generateToken(): AccessTokenResponse {
        return APIFactory.create().doAccessToken()
    }
}