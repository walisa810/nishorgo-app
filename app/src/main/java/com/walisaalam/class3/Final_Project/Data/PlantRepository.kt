package com.walisaalam.class3.Final_Project.Data

import android.content.Context
import androidx.room.Query
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PlantRepository(private val plantDao: PlantDao) {
    suspend fun getAllPlants(): List<PlantEntity> = plantDao.getAllPlants()

    suspend fun getPlantsByCategory(categoryName: String): List<PlantEntity> = plantDao.getPlantsByCategory(categoryName)

    suspend fun getPlantsByName(plantName: String): List<PlantEntity> = plantDao.getPlantsByName(plantName)
    // Function to load plants from JSON and insert into the database
    suspend fun loadAndInsertPlantsFromJson(context: Context) {
        val jsonString = loadJsonFromAssets(context, "plants.json")
        val plants = parseJsonToPlants(jsonString)
        insertPlants(plants)
    }

    // Load JSON file from assets
    private fun loadJsonFromAssets(context: Context, fileName: String): String {
        val inputStream = context.assets.open(fileName)
        return inputStream.bufferedReader().use { it.readText() }
    }

    // Parse the JSON string to a list of PlantEntity objects
    private fun parseJsonToPlants(jsonString: String): List<PlantEntity> {
        val gson = Gson()
        val plantListType = object : TypeToken<List<PlantEntity>>() {}.type
        return gson.fromJson(jsonString, plantListType)
    }

    // Insert the list of plants into the database
    private suspend fun insertPlants(plants: List<PlantEntity>) {
        withContext(Dispatchers.IO) {
            plantDao.insertPlants(plants)  // Assuming you have a DAO method like insertPlants()
        }
    }

}