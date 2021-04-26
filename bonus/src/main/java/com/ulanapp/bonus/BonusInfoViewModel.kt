package com.ulanapp.bonus

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ulanapp.network.actions.APIAccessTokenActions
import com.ulanapp.network.actions.APIBonusInfoActions
import com.ulanapp.network.responses.BonusInfoResponse
import com.ulanapp.network.responses.RequestBody
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import timber.log.Timber
import java.lang.Exception

class BonusInfoViewModel(
    private var apiAccessTokenActions: APIAccessTokenActions,
    private var apiBonusInfoActions: APIBonusInfoActions
): ViewModel() {

    var bonusInfo = MutableLiveData<BonusInfoResponse.Data>()

    // загружаем инфу о бонусе с сервера
    fun loadBonusData(requestBody: RequestBody) {
        try {
            viewModelScope.launch {

                // запрашиваем токен
                val token = async(Dispatchers.IO) {
                    apiAccessTokenActions.getToken(requestBody).accessToken
                }.await()
                Timber.d("Token $token")

                // запрашиваем инфу о бонусе по токену
                val responseData = apiBonusInfoActions.getGeneralInfo(token)
                bonusInfo.value = responseData.data
                Timber.d("BonusData $responseData")
            }
        }catch (e: Exception){
            Timber.d(e.localizedMessage)
        }
    }
}