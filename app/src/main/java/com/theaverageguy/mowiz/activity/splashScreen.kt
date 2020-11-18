package com.theaverageguy.mowiz.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.theaverageguy.mowiz.R

class splashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)
        val intent = Intent(this, Home::class.java)
        Handler().postDelayed({
            startActivity(intent)
            finish()
        }, 1500)
    }
}