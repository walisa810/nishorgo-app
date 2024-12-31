package com.walisaalam.class3.Final_Project

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.walisaalam.class3.R
import com.walisaalam.class3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Floating Action Button to navigate to AddActivity
        binding.floatingAddButton.setOnClickListener {
            startActivity(Intent(this, AddActivity::class.java))
        }

        // Sample blog data
        val blogPosts = listOf(
            BlogPost(
                title = "Philodendron Tortum Care Guide",
                author = "Faozia Fariha",
                content = "The Philodendron tortum is prized for its long, fern-like leaves...",
                date = "Jul 29, 2024",
                imageurl = "https://example.com/article2.jpg"
            ),
            BlogPost(
                title = "5 Best Indoor Plants for Beginners",
                author = "John Doe",
                content = "Starting with indoor plants? Here are 5 options to consider...",
                date = "Aug 10, 2024",
                imageurl = "https://example.com/article1.jpg"
            )
        )

        // Set up RecyclerView with BlogAdapter
        binding.blogRecylerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = BlogAdapter(blogPosts)
        }

        // Bottom navigation setup
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> {
                    // Handle Home navigation
                    true
                }
                R.id.menu_info -> {
                    // Handle Info navigation
                    true
                }
                R.id.menu_notifications -> {
                    // Navigate to NotificationActivity
                    startActivity(Intent(this, NotificationActivity::class.java))
                    true
                }
                else -> false
            }
        }

        // Handle window insets for immersive UI
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
