package com.ulanapp.network.actions

import com.ulanapp.network.client.APIFactory
import com.ulanapp.network.responses.BonusInfoResponse
import javax.inject.Inject

class APIBonusInfoActionsImpl @Inject constructor() : APIBonusInfoActions {

    override suspend fun getGeneralInfo(accessToken: String): BonusInfoResponse {
        return APIFactory.create().getGeneralInfo(accessToken)
    }
}