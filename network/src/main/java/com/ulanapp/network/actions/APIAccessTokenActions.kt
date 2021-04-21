package com.ulanapp.network.actions

import com.ulanapp.network.responses.AccessTokenResponse

interface APIAccessTokenActions {

    suspend fun generateToken() : AccessTokenResponse
}