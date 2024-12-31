package com.walisaalam.class3.Final_Project

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.FirebaseApp
import com.walisaalam.class3.Final_Project.Data.PlantEntity
import com.walisaalam.class3.Final_Project.ViewModel.MainViewModel
import com.walisaalam.class3.databinding.ActivityFloweringPlantsBinding

class Flowering_Plants : BaseActivity() {

    private lateinit var binding: ActivityFloweringPlantsBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        FirebaseApp.initializeApp(this);
        binding = ActivityFloweringPlantsBinding.inflate(layoutInflater)
        setContentView(binding.root)

//      val rvPlantRecyclerView = findViewById<RecyclerView>(R.id.rvPlantList)
        //layoutManager

        binding.rvPlantList.layoutManager = GridLayoutManager(this,2)
        //adapter
        val plantAdapter = PlantAdapter()
        binding.rvPlantList.adapter = plantAdapter

        // Observe ViewModel's LiveData
        val plantObserver = Observer<List<PlantEntity>> { plants ->
            if(plants.isNotEmpty()) {
                Log.d("FloweringPlants", "Data received: $plants")
                plantAdapter.submitList(plants)
            } else {
                Log.d("FloweringPlants", "No data found!")
            }
        }
        viewModel.flowerPlantList.observe(this, plantObserver)

        viewModel.fetchPlantsByCategory("Flowering Plant")

    }
    companion object{
        @JvmStatic
        fun newInstance() = Flowering_Plants()
    }
}