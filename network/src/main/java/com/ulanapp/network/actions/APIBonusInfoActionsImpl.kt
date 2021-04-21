package com.ulanapp.network.actions

import com.ulanapp.network.client.APIFactory
import com.ulanapp.network.responses.BonusInfoResponse

class APIBonusInfoActionsImpl : APIBonusInfoActions {

    override suspend fun getGeneralInfo(accessToken: String): BonusInfoResponse {
        return APIFactory.create().getGeneralInfo(accessToken)
    }
}