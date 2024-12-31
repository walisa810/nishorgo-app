package com.walisaalam.class3.Final_Project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.walisaalam.class3.R

class NotificationActivity : AppCompatActivity() {

        private lateinit var recyclerView: RecyclerView
        private lateinit var notificationAdapter: NotificationAdapter

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_notification)

//            // Initialize RecyclerView
//            recyclerView = findViewById(R.id.recyclerView)
//            recyclerView.layoutManager = LinearLayoutManager(this)
//
//            // Create sample data for notifications
//            val notifications = listOf(
//                NotificationItem("Watering Reminder", "Lorem ipsum dolor sit amet.", "10m ago"),
//                NotificationItem("XYZ Published new article", "Lorem ipsum dolor sit amet.", "10m ago"),
//                NotificationItem("Water Snake Plant", "Lorem ipsum dolor sit amet.", "20m ago")
//            )
//
//            // Initialize and set Adapter
//            notificationAdapter = NotificationAdapter(notifications)
//            recyclerView.adapter = notificationAdapter
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}