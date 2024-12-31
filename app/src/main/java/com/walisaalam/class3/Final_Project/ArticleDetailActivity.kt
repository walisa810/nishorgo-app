package com.walisaalam.class3.Final_Project

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.walisaalam.class3.R
import com.walisaalam.class3.databinding.ActivityArticleDetailBinding

class ArticleDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityArticleDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArticleDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get data from intent
        val title = intent.getStringExtra("title")
        val content = intent.getStringExtra("content")
        val author = intent.getStringExtra("author")
        val date = intent.getStringExtra("date")

        // Bind data to views
        binding.title.text = title
        binding.content.text = content
        binding.author.text = author // Bind the actual author
        binding.date.text = date

        // Set up back button (imageView2)
        binding.imageView2.setOnClickListener {
            // Finish the current activity to go back to MainActivity
            finish()
        }

        // Bottom navigation setup
//        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)
//        bottomNavigation.setOnItemSelectedListener { item ->
//            when (item.itemId) {
//                R.id.menu_home -> {
//                    // Handle Home navigation
//                    true
//                }
//                R.id.menu_info -> {
//                    // Handle Info navigation
//                    true
//                }
//                R.id.menu_notifications -> {
//                    // Navigate to NotificationActivity
//                    startActivity(Intent(this, NotificationActivity::class.java))
//                    true
//                }
//                else -> false
//            }
//        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
