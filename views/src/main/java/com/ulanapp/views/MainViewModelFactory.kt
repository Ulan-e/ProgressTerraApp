package com.ulanapp.views

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ulanapp.network.actions.APIAccessTokenActions
import com.ulanapp.network.actions.APIBonusInfoActions

class MainViewModelFactory (
    private var apiAccessTokenActions: APIAccessTokenActions,
    private var apiBonusInfoActions: APIBonusInfoActions
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(apiAccessTokenActions, apiBonusInfoActions) as T
    }
}