package com.ulanapp.progressterraapp

import android.app.Application
import com.ulanapp.bonus.di.BonusInfoComponent
import com.ulanapp.bonus.di.BonusNetworkProvider
import com.ulanapp.bonus.di.DaggerBonusInfoComponent
import com.ulanapp.network.di.DaggerNetworkComponent
import com.ulanapp.network.di.NetworkComponent
import com.ulanapp.network.di.NetworkComponentProvider

class MainApplication: Application(), NetworkComponentProvider, BonusNetworkProvider{

    override fun provideNetworkComponent(): NetworkComponent {
        return DaggerNetworkComponent.builder()
                .build()
    }

    override fun provideBonusInfoComponent(): BonusInfoComponent {
        return DaggerBonusInfoComponent.builder()
                .build()
    }

}