package com.ulanapp.progressterraapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ulanapp.views.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, MainFragment())
            .addToBackStack(null)
            .commit()
    }
}