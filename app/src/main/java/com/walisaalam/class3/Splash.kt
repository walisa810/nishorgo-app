package com.walisaalam.class3

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class Splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)

    }

    override fun onStart() {
        super.onStart()
        splashAnimation()
    }


    private fun splashAnimation(){
        val ivlogo = findViewById<ImageView>(R.id.ivLogo)
        val tvlogotext = findViewById<TextView>(R.id.tvLogoText)

        ValueAnimator.ofFloat(0f,45f).apply{
            duration = 2000
            addUpdateListener { animation ->
                val animatedValue = animation.animatedValue as Float
                ivlogo.rotationY = animatedValue
                //ivlogo.rotationX = animatedValue
                ivlogo.translationX = -animatedValue * 5
                tvlogotext.translationX = animatedValue
                tvlogotext.alpha = (animatedValue * 3) / 135
                tvlogotext.scaleX = animatedValue / 25
                tvlogotext.scaleY = animatedValue / 25
            }
            addListener(object : AnimatorListenerAdapter(){
                override fun onAnimationEnd(animation : Animator){
                    val intent = Intent(this@Splash, MainActivity2::class.java)
                    startActivity(intent)
                }
            })
            start()
        }
    }
}