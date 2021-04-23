package com.ulanapp.views

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ulanapp.network.actions.APIAccessTokenActions
import com.ulanapp.network.actions.APIBonusInfoActions
import kotlinx.coroutines.launch

class MainViewModel(
    private var apiAccessTokenActions: APIAccessTokenActions,
    private var apiBonusInfoActions: APIBonusInfoActions
): ViewModel() {

    init {
        viewModelScope.launch {
            val result = apiAccessTokenActions.generateToken()
            apiBonusInfoActions.getGeneralInfo(result.toString())
        }
    }
}