package com.ulanapp.network.actions

interface AccessTokenActions {

    suspend fun generateToken() : Any
}