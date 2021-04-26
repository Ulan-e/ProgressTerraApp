package com.ulanapp.network.actions

import com.ulanapp.network.responses.BonusInfoResponse

interface APIBonusInfoActions {

    // получение информацию о бонусе
    suspend fun getGeneralInfo(accessToken: String): BonusInfoResponse
}