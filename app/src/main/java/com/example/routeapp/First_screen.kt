package com.example.routeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class First_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_screen)

        Handler(Looper.getMainLooper()).postDelayed(
            {
                val intent = Intent(this@First_screen, MainActivity::class.java)
                startActivity(intent)
            }, 2000
        )
    }
}