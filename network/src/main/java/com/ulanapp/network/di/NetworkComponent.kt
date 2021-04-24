package com.ulanapp.network.di

import com.ulanapp.network.actions.APIAccessTokenActions
import com.ulanapp.network.actions.APIBonusInfoActions
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class])
interface NetworkComponent{

    fun getAccessToken() : APIAccessTokenActions

    fun getBonusInfo() : APIBonusInfoActions
}