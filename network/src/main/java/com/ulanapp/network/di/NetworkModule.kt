package com.ulanapp.network.di

import com.ulanapp.network.actions.APIAccessTokenActions
import com.ulanapp.network.actions.APIAccessTokenActionsImpl
import com.ulanapp.network.actions.APIBonusInfoActions
import com.ulanapp.network.actions.APIBonusInfoActionsImpl
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {

    @Provides
    fun provideAPIAccessAction(): APIAccessTokenActions = APIAccessTokenActionsImpl()

    @Provides
    fun provideAPIBonusInfoAction() : APIBonusInfoActions = APIBonusInfoActionsImpl()
}