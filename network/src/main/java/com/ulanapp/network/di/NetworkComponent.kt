package com.ulanapp.network.di

import android.app.Application
import com.ulanapp.network.actions.APIAccessTokenActions
import com.ulanapp.network.actions.APIBonusInfoActions
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class])
interface NetworkComponent{

    fun inject(application: Application)

    fun getAccessToken() : APIAccessTokenActions

    fun getBonusInfo() : APIBonusInfoActions
}