package com.walisaalam.class3.Final_Project

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.walisaalam.class3.Final_Project.Data.PlantDatabase
import com.walisaalam.class3.Final_Project.Data.PlantEntity
import com.walisaalam.class3.Final_Project.Data.PlantRepository
import kotlinx.coroutines.launch



class PlantViewModel(private val plantRepository: PlantRepository): ViewModel() {

    private val _plantList = MutableLiveData<List<PlantEntity>>()
    val plantList: LiveData<List<PlantEntity>> get() = _plantList

//    // Function to load and insert plants from JSON
//    fun loadAndInsertPlantsFromJson(context: Context) {
//        viewModelScope.launch {
//            plantRepository.loadAndInsertPlantsFromJson(context)
//            // After inserting, fetch the plants to update the LiveData
//            val plants = plantRepository.getAllPlants()
//            _plantList.postValue(plants)
//        }
//    }
//
//    fun getAllPlants() {
//        viewModelScope.launch {
//            val plants = plantRepository.getAllPlants()
//            Log.d("FloweringPlants", "All Plants Fetched: ${plants.size}")
//            _plantList.postValue(plants)
//        }
//    }
//
//    fun getPlantsByCategory(category: String) {
//        viewModelScope.launch {
//            val plants = plantRepository.getPlantsByCategory(category)
//            _plantList.postValue(plants)
//        }
//    }



    companion object{
        @Suppress("UNCHECKED_CAST")
        fun getfactory(context: Context): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T :ViewModel> create(modelClass: Class<T>): T{
                val dao = PlantDatabase.getDatabase(context).plantDao()
                val repository = PlantRepository(dao)
                return PlantViewModel(repository) as T
            }
        }
    }
}
