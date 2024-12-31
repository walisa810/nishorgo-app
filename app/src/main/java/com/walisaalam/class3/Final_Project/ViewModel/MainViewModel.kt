package com.walisaalam.class3.Final_Project.ViewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.walisaalam.class3.Final_Project.Data.ArticleEntity
import com.walisaalam.class3.Final_Project.Data.PlantEntity

class MainViewModel: ViewModel() {

    private val firebaseDatabase: DatabaseReference by lazy {
        FirebaseDatabase.getInstance().reference
    }

    private val _plantList = MutableLiveData<MutableList<PlantEntity>>()
    val plantList: LiveData<MutableList<PlantEntity>> get() = _plantList

    private val _flowerPlantList = MutableLiveData<MutableList<PlantEntity>>()
    val flowerPlantList: LiveData<MutableList<PlantEntity>> get() = _flowerPlantList

    private val _fruitPlantList = MutableLiveData<MutableList<PlantEntity>>()
    val fruitPlantList: LiveData<MutableList<PlantEntity>> get() = _fruitPlantList

    private val _vegetablePlantList = MutableLiveData<MutableList<PlantEntity>>()
    val vegetablePlantList: LiveData<MutableList<PlantEntity>> get() = _vegetablePlantList

    private val _articleList = MutableLiveData<MutableList<ArticleEntity>>()
    val articleList:  LiveData<MutableList<ArticleEntity>> get() = _articleList


    fun fetchPlantsFromFirebase() {
        firebaseDatabase.child("Plants").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val plants = mutableListOf<PlantEntity>()
                for (plantSnapshot in snapshot.children) {
                    val plant = plantSnapshot.getValue(PlantEntity::class.java)
                    Log.d("Plant", "Fetched plant: $plant")
                    if (plant != null) {
                        plants.add(plant)
                    }

                }
                _plantList.value = plants
            }
            override fun onCancelled(error: DatabaseError) {
                Log.e("PlantViewModel", "Firebase error: ${error.message}")
            }
        })
    }
    fun fetchArticlesFromFirebase() {
        firebaseDatabase.child("Articles").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val articles = mutableListOf<ArticleEntity>()
                for (articleSnapshot in snapshot.children) {
                    val article = articleSnapshot.getValue(ArticleEntity::class.java)
                    Log.d("Article", "Fetched article: $article")
                    if (article != null) {
                        articles.add(article)
                    }

                }
                _articleList.value = articles
            }
            override fun onCancelled(error: DatabaseError) {
                Log.e("ArticleViewModel", "Firebase error: ${error.message}")
            }
        })
    }
    fun fetchPlantsByCategory(category: String) {
        firebaseDatabase.child("Plants").orderByChild("category").equalTo(category)
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val categoryPlants = mutableListOf<PlantEntity>()
                    for (plantSnapshot in snapshot.children) {
                        val plant = plantSnapshot.getValue(PlantEntity::class.java)
                        Log.d("CategoryPlant", "Fetched plant in category $category: $plant")
                        if (plant != null) {
                            categoryPlants.add(plant)
                        }
                    }
                    if( category == "Flowering Plant")
                        _flowerPlantList.value = categoryPlants
                    else if ( category == "fruit")
                        _fruitPlantList.value = categoryPlants
                    else if  ( category == "vegetable")
                        _vegetablePlantList.value = categoryPlants

                }

                override fun onCancelled(error: DatabaseError) {
                    Log.e("CategoryViewModel", "Firebase error: ${error.message}")
                }
            })
    }
}