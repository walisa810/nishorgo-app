package com.walisaalam.class3.Final_Project.Data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PlantDao {
    @Insert
    suspend fun insertPlants(plants: List<PlantEntity>)

    @Query("SELECT * FROM plants ORDER BY name ASC")
    suspend fun getAllPlants(): List<PlantEntity>

    @Query("SELECT * FROM plants WHERE category=:categoryName ORDER BY name ASC")
    suspend fun getPlantsByCategory(categoryName: String): List<PlantEntity>

    @Query("SELECT * FROM plants WHERE name LIKE :plantName || '%' ORDER BY name ASC")
    suspend fun getPlantsByName(plantName: String): List<PlantEntity>

}