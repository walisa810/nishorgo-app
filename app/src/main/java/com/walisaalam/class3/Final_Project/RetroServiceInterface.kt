package com.walisaalam.class3.Final_Project

import com.walisaalam.class3.MovieApp.MovieResponse
import retrofit2.http.GET

interface RetroServiceInterface {
    @GET("plants?filter[flower]=true&token=Oxlm02HuIDY9nIkB4g96Muq3ZTixfeh083QfLnMD_08")
    // poster_path, original_title, vote_average, release_date, overview
    suspend fun getDataFromApi(): PlantResponse
}
