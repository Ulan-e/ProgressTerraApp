package com.ulanapp.network.actions

import com.ulanapp.network.client.APIFactory

class AccessTokenActionsImpl : AccessTokenActions {

    override suspend fun generateToken(): Any {
        return APIFactory.create().doAccessToken()
    }
}