package com.walisaalam.class3.recyclerVew

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.walisaalam.class3.R

class recyclerViewDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler_view_demo)
        val rvProductRecyclerView = findViewById<RecyclerView>(R.id.rvProductList)

        //layoutManager
        rvProductRecyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        //adapter
        val productAdapter = DifferentProductAdapter(getDummyData())
        rvProductRecyclerView.adapter = productAdapter
    }
    fun getDummyData(): ArrayList<Product>{
        val DummyData = ArrayList<Product>()
        for(i in 0..100){
            DummyData.add(Product( name ="Product $i", image="", description = ""))
        }
        return DummyData
    }
}