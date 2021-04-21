package com.ulanapp.network.actions

import com.ulanapp.network.client.APIFactory

class GeneralInfoActionImpl : GeneralInfoAction {

    override suspend fun getGeneralInfo(accessToken: String): Any {
        return APIFactory.create().getGeneralInfo(accessToken)
    }
}