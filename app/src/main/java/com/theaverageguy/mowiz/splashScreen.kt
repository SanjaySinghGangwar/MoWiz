package com.theaverageguy.mowiz

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class splashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)
        val intent = Intent(this, home::class.java)
        Handler().postDelayed({
            startActivity(intent)
            finish()
        }, 1500)
    }
}