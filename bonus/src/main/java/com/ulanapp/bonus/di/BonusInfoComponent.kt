package com.ulanapp.bonus.di

import com.ulanapp.bonus.MainFragment
import com.ulanapp.network.di.NetworkComponent
import dagger.Component
import javax.inject.Singleton

@Component(
    dependencies = [NetworkComponent::class],
    modules = [BonusInfoModule::class]
)
interface BonusInfoComponent {

    fun inject(fragment: MainFragment)
}