package com.ulanapp.bonus.di

import com.ulanapp.bonus.BonusInfoFragment
import com.ulanapp.network.di.NetworkComponent
import dagger.Component

@Component(dependencies = [NetworkComponent::class])
interface BonusInfoComponent {

    fun inject(fragment: BonusInfoFragment)
}