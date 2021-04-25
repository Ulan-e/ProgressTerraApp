package com.ulanapp.progressterraapp.di

import com.ulanapp.progressterraapp.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface AppComponent {

    fun inject(activity: MainActivity)
}