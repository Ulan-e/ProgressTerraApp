package com.ulanapp.progressterraapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ulanapp.bonus.MainFragment
import com.ulanapp.progressterraapp.di.AppComponentProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as AppComponentProvider)
                .getAppComponent()
                .inject(this)

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, MainFragment())
            .addToBackStack(null)
            .commit()
    }
}