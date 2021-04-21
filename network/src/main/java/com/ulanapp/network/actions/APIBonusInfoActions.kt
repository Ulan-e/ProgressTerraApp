package com.ulanapp.network.actions

import com.ulanapp.network.responses.BonusInfoResponse

interface APIBonusInfoActions {

    suspend fun getGeneralInfo(accessToken: String): BonusInfoResponse
}