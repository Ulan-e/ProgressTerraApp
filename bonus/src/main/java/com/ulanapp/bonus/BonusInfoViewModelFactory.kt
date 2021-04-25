package com.ulanapp.bonus

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ulanapp.network.actions.APIAccessTokenActions
import com.ulanapp.network.actions.APIBonusInfoActions

class BonusInfoViewModelFactory (
    private var apiAccessTokenActions: APIAccessTokenActions,
    private var apiBonusInfoActions: APIBonusInfoActions
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return BonusInfoViewModel(apiAccessTokenActions, apiBonusInfoActions) as T
    }
}