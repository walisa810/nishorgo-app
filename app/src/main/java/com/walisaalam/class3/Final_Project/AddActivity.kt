package com.walisaalam.class3.Final_Project

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.walisaalam.class3.R

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add)

        val titleInput = findViewById<EditText>(R.id.titlein)
        val descriptionInput = findViewById<EditText>(R.id.des)
        val cancelButton = findViewById<Button>(R.id.cancelButton)
        val submitButton = findViewById<Button>(R.id.submitButton)
        val imageView2 = findViewById<ImageView>(R.id.imageView2)

        cancelButton.setOnClickListener {
            finish() // Close the activity
        }

        submitButton.setOnClickListener {
            val title = titleInput.text.toString()
            val description = descriptionInput.text.toString()
            if (title.isEmpty() || description.isEmpty()) {
                Toast.makeText(this, "All fields are required!", Toast.LENGTH_SHORT).show()
            } else {
                // Handle submission logic
                Toast.makeText(this, "Submitted!", Toast.LENGTH_SHORT).show()
            }
        }

        // OnClickListener for imageView2
        imageView2.setOnClickListener {
            finish() // Close the AddActivity and return to MainActivity
        }

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)
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
//                    // Handle Notifications navigation
//                    true
//                }
//                else -> false
//            }
//        }
    }

}