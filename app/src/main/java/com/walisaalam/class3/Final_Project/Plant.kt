package com.walisaalam.class3.Final_Project

import com.walisaalam.class3.MovieApp.Item

data class PlantResponse(
    val data: ArrayList<Plant>
)
data class Plant(
    val common_name :String?,
    val scientific_name : String?,
    val image_url : String?
)
