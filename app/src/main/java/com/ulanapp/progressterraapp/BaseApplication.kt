package com.ulanapp.progressterraapp

import android.app.Application
import com.ulanapp.bonus.di.BonusInfoComponent
import com.ulanapp.bonus.di.BonusInfoComponentProvider
import com.ulanapp.bonus.di.DaggerBonusInfoComponent
import com.ulanapp.network.di.DaggerNetworkComponent
import com.ulanapp.network.di.NetworkComponent
import com.ulanapp.network.di.NetworkComponentProvider
import com.ulanapp.network.di.NetworkModule
import com.ulanapp.progressterraapp.di.AppComponent
import com.ulanapp.progressterraapp.di.AppComponentProvider
import com.ulanapp.progressterraapp.di.DaggerAppComponent

class BaseApplication : Application(), AppComponentProvider, NetworkComponentProvider, BonusInfoComponentProvider {

    private lateinit var networkComponent: NetworkComponent

    override fun onCreate() {
        super.onCreate()

        networkComponent = DaggerNetworkComponent.builder()
                .networkModule(NetworkModule())
                .build()
        networkComponent.inject(this)
    }

    override fun provideNetworkComponent(): NetworkComponent {
        return networkComponent
    }

    override fun provideBonusInfoComponent(): BonusInfoComponent {
        return DaggerBonusInfoComponent.builder()
                .networkComponent(networkComponent)
                .build()
    }

    override fun provideAppComponent(): AppComponent {
        return DaggerAppComponent.builder()
                .build()
    }
}