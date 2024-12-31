package com.walisaalam.class3.MovieApp

import java.util.Date
data class MovieResponse(
    val results: ArrayList<Item>
)

data class Item(
    val poster_path: String?,
    val original_title: String?,
    val vote_average: Double?,
    val release_date: String?,
    val overview: String?
)

//poster_path, original_title, vote_average, release_date, overview