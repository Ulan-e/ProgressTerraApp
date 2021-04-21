package com.ulanapp.network.actions

interface GeneralInfoAction {

    suspend fun getGeneralInfo(accessToken: String): Any
}