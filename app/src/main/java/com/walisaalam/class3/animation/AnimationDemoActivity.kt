package com.walisaalam.class3.animation

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.BounceInterpolator
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.walisaalam.class3.R

class AnimationDemoActivity : AppCompatActivity() {
    lateinit var btnAction: Button
    lateinit var ivImage: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_animation_demo)
        btnAction = findViewById(R.id.btnAction)
        ivImage = findViewById(R.id.ivImage)

        btnAction.setOnClickListener{
            // fade out animation
            //fadeOutAnimationExample()
            //scaleAnimationWithDurationExample()
            //interpolatorExample()
            //animatorSetExample()
            //viewPropertyAnimation()
            customValueAnimator()
        }


    }
    private fun fadeOutAnimationExample(){
        val fadeAnimation = ObjectAnimator.ofFloat(ivImage, View.ALPHA,0.2f)
        fadeAnimation.start()
    }
    private fun scaleAnimationWithDurationExample() {
        val scaleAnimation = ObjectAnimator.ofFloat(ivImage, View.SCALE_X,1.0f,2.0f)
        scaleAnimation.duration = 1000
        scaleAnimation.repeatCount = ValueAnimator.INFINITE
        scaleAnimation.repeatMode = ValueAnimator.REVERSE
        scaleAnimation.start()
    }
    private fun interpolatorExample() {
        ObjectAnimator.ofFloat(ivImage,"translationY",-200f).apply{
            duration = 1000
            addListener(object : AnimatorListenerAdapter(){
                override fun onAnimationEnd(animation : Animator){
                    ObjectAnimator.ofFloat(btnAction,"translationY",200f).apply{
                        duration = 1000
                        start()
                    }
                }
            })
            start()
        }
    }
    private fun animatorSetExample(){
        val animatorSet = AnimatorSet()
        animatorSet.playTogether(
            ObjectAnimator.ofFloat(ivImage,View.SCALE_X,1.0f,2.0f).setDuration(2000),
            ObjectAnimator.ofFloat(ivImage,View.SCALE_Y,1.0f,2.0f).setDuration(2000),
            ObjectAnimator.ofFloat(ivImage,View.TRANSLATION_Y,-200f).setDuration(2000) ,
        )
        animatorSet.start()
    }
    private fun multiAnimatorSetExample(){
        val scaleAnimatorSet = AnimatorSet()
        val scaleXAnimator = ObjectAnimator.ofFloat(ivImage,View.SCALE_X,1.0f,2.0f).apply{
            duration = 2000
        }
        val scaleYAnimator = ObjectAnimator.ofFloat(ivImage,View.SCALE_Y,1.0f,2.0f).apply{
            duration = 2000
        }
        scaleAnimatorSet.apply{
            playTogether(scaleXAnimator,scaleYAnimator)
        }

        val translationAnimatorSet = AnimatorSet()
        val translationXAnimator = ObjectAnimator.ofFloat(ivImage,View.TRANSLATION_X,200f).apply{
            duration = 2000
        }
        val translationYAnimator = ObjectAnimator.ofFloat(ivImage,View.TRANSLATION_Y,200f).apply{
            duration = 2000
        }
        translationAnimatorSet.apply{
            playTogether(translationXAnimator,translationYAnimator)
        }

        val multiAnimatorSet = AnimatorSet()
        multiAnimatorSet.apply{
            playTogether(scaleAnimatorSet,translationAnimatorSet)
            start()
        }
    }
    private fun viewPropertyAnimation(){
        ivImage.animate().alpha(0.2f).xBy(-100f).yBy(100f)
    }
    private fun customValueAnimator(){
        val valueAnimator = ValueAnimator.ofFloat(1.0f,0.0f)
        valueAnimator.setDuration(1000)
        valueAnimator.addUpdateListener { animation ->
            val animatedValue = animation.animatedValue as Float
            ivImage.alpha = animatedValue
        }
        valueAnimator.start()
    }
    // Glide / Picasso
    
}