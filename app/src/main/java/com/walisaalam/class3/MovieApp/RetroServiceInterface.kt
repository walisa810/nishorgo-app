package com.walisaalam.class3.MovieApp

import retrofit2.http.GET

interface RetroService {
    @GET("movie/popular?api_key=804cafa0eb81beeaaa347534823e9e75")
    // poster_path, original_title, vote_average, release_date, overview
    suspend fun getDataFromApi(): MovieResponse

}