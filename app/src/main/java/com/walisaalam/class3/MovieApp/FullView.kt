package com.walisaalam.class3.MovieApp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.walisaalam.class3.R

class FullView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_full_view)
        val title = intent.getStringExtra("title")
        val image = intent.getStringExtra("image")
        val rating = intent.getStringExtra("rating")
        val release = intent.getStringExtra("release")
        val details = intent.getStringExtra("details")

        if (rating != null)
            findViewById<TextView>(R.id.tvFullMovieTitle).text = "$title ($rating)"
        else findViewById<TextView>(R.id.tvFullMovieTitle).text = title
//        findViewById<TextView>(R.id.tvRating).text = rating
        findViewById<TextView>(R.id.tvFullMovieRelease).text = release
        findViewById<TextView>(R.id.tvFullMovieDetails).text = details
        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500$image")
            .placeholder(R.drawable.photo1)
            .error(R.drawable.photo2)
            .into(findViewById(R.id.ivFullMovieImage))
    }
}