package com.walisaalam.class3.Final_Project

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.view.WindowInsetsController
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.FirebaseApp
import com.walisaalam.class3.Final_Project.Data.ArticleEntity
import com.walisaalam.class3.Final_Project.ViewModel.MainViewModel
import com.walisaalam.class3.databinding.ActivityHome1Binding


class Home : BaseActivity() {


    private lateinit var binding: ActivityHome1Binding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()



        FirebaseApp.initializeApp(this);
        binding = ActivityHome1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cvFloweringPlants.setOnClickListener{
            val intent = Intent( this@Home,
                Flowering_Plants::class.java)
            startActivity(intent)
        }
        binding.progressBarArticle.visibility = View.VISIBLE
        Handler(Looper.getMainLooper()).postDelayed({
            // Hide ProgressBar after 1 second
            binding.progressBarArticle.visibility = View.GONE
        }, 1000)

        // layout
        binding.rvArticleList.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.HORIZONTAL,false)
        //adapter
        val articleAdapter = ArticleAdapter()
        binding.rvArticleList.adapter = articleAdapter

        // Observe ViewModel's LiveData
        val articleObserver = Observer<List<ArticleEntity>> { articles ->
            if( articles.isNotEmpty()) {
                Log.d("Articles", "Data received: $articles")
                articleAdapter.submitList(articles)
            } else {
                Log.d("Articles", "No data found!")
            }
        }
        viewModel.articleList.observe(this, articleObserver)

        viewModel.fetchArticlesFromFirebase()


        binding.ibHome.setOnClickListener{
            val intent = Intent( this@Home,
                Home::class.java)
            startActivity(intent)
        }
        binding.ibArticle.setOnClickListener{
            val intent = Intent( this@Home,
                Home::class.java)
            startActivity(intent)
        }


    }
    override fun onResume() {
        super.onResume()

    }
}