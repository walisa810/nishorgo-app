package com.walisaalam.class3.Final_Project

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.walisaalam.class3.Final_Project.Data.ArticleEntity
import com.walisaalam.class3.Final_Project.Data.PlantEntity
import com.walisaalam.class3.R

class PlantAdapter: RecyclerView.Adapter<PlantAdapter.PlantViewHolder>() {

    private val plantList = mutableListOf<PlantEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.plant_view,parent,false)
        val viewHolder = PlantViewHolder(view)
        return viewHolder
    }
    override fun getItemCount(): Int {
        return plantList.size
    }

    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
        val plantEntity = plantList[position]
        holder.setData(plantEntity)
       holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, PlantView::class.java)
           intent.putExtra("plant_entity", plantList[position]) // Pass the entire PlantEntity
           holder.itemView.context.startActivity(intent)
        }
    }
    class PlantViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val ivItemImage: ImageView
        val tvItemName: TextView
        val tvItemDescription: TextView
        init{
            ivItemImage = itemView.findViewById(R.id.ivItemImage)
            tvItemName = itemView.findViewById(R.id.tvItemName)
            tvItemDescription = itemView.findViewById(R.id.tvItemDescription)
        }

        fun setData(product: PlantEntity){
            tvItemName.text = product.name ?: "Unknown Name"
            tvItemDescription.text = product.scientific_name ?: "N/A"

            Glide.with(ivItemImage.context)
                .load(product.image)
                .placeholder(R.drawable.photo1)
                .error(R.drawable.photo2)
                .into(ivItemImage)

        }
    }
    fun submitList(newPlants: List<PlantEntity>) {
        plantList.clear()
        plantList.addAll(newPlants)
        notifyDataSetChanged()
    }

}