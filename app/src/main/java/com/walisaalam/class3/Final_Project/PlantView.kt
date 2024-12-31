package com.walisaalam.class3.Final_Project

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.walisaalam.class3.Final_Project.Data.PlantEntity
import com.walisaalam.class3.R
import com.walisaalam.class3.databinding.ActivityFloweringPlantsBinding
import com.walisaalam.class3.databinding.ActivityPlantViewBinding

class PlantView : BaseActivity() {
    private lateinit var binding: ActivityPlantViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPlantViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val plantEntity = intent.getParcelableExtra("plant_entity", PlantEntity::class.java)

        plantEntity?.let {
            // Use the plantEntity object
            Log.d("PlantView", "Received Plant: ${it.name}, ${it.scientific_name}")
            val name = it.name
            val scientificName = it.scientific_name
            val image = it.image
            val description = it.description
            val light = it.light
            val water = it.water
            val toxicity = it.toxicity
            val humidity = it.humidity
            val overview = it.overview

            Glide.with(binding.ivPlantImage.context)
                .load(image)
                .placeholder(R.drawable.photo1)
                .error(R.drawable.photo2)
                .into(binding.ivPlantImage)
            binding.tvPlantName.text = name
            binding.tvPlantScientificName.text = scientificName
            binding.tvtoxicity.text = toxicity
            binding.tvSunlight.text = light
            binding.tvWater.text = water
            binding.tvDescription.text = description
            binding.tvOverview.text = overview
        }

        binding.ibHome.setOnClickListener{
            val intent = Intent(this@PlantView, Home::class.java)
            startActivity(intent)
        }

    }
}