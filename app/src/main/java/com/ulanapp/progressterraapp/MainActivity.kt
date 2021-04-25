package com.ulanapp.progressterraapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ulanapp.bonus.BonusInfoFragment
import com.ulanapp.progressterraapp.di.AppComponentProvider

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // инжект активити
        (application as AppComponentProvider)
                .provideAppComponent()
                .inject(this)

        // запускаем фрагмент бонусов
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, BonusInfoFragment())
            .addToBackStack(null)
            .commit()
    }
}