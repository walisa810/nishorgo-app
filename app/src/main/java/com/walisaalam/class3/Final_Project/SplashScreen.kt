package com.walisaalam.class3.Final_Project

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.walisaalam.class3.Final_Project.EncryptedLogin
import com.walisaalam.class3.R

class SplashScreen : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // Delay for 2 seconds before navigating to MainActivity
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@SplashScreen, EncryptedLogin::class.java))
            finish()
        }, 3000) // Delay for 3 seconds

    }

}
