package com.walisaalam.class3.MovieApp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.walisaalam.class3.R
import com.walisaalam.class3.viewmodelclass.TennisScoreViewModel


class Front : AppCompatActivity() {

    private val frontViewModel: FrontViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_front)
        val rvMovieRecyclerView = findViewById<RecyclerView>(R.id.gvMovieList)

        //layoutManager
        rvMovieRecyclerView.layoutManager = GridLayoutManager(this, 2)
        //adapter
        val productAdapter = MovieAdapter()
        rvMovieRecyclerView.adapter = productAdapter
        // Observe ViewModel's LiveData
        frontViewModel.getLiveDataObserver().observe(this, Observer { movieList ->
            if (movieList != null) {
                productAdapter.setUpdatedData(movieList)
            }
        })

        // Trigger API call to fetch data
        frontViewModel.makeApiCall()
    }
    companion object{
        @JvmStatic
        fun newInstance() = Front()
    }
}