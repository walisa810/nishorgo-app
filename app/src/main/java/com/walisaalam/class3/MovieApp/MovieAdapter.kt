package com.walisaalam.class3.MovieApp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.walisaalam.class3.R


class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>()  {
    var movieList = ArrayList<Item>()

    fun setUpdatedData(items : ArrayList<Item> ){
        this.movieList = items
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.grid_item,parent,false)
        val viewHolder = MovieViewHolder(view)

        return viewHolder
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieAdapter.MovieViewHolder, position: Int) {
        holder.setData(movieList[position],position)
        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, FullView::class.java)
            intent.putExtra("title", movieList[position].original_title)
            intent.putExtra("image", movieList[position].poster_path)
            intent.putExtra("rating", movieList[position].vote_average)
            intent.putExtra("release", movieList[position].release_date)
            intent.putExtra("details", movieList[position].overview)
            holder.itemView.context.startActivity(intent)
        }
    }
    class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val ivMovieImage: ImageView
        val tvMovieName: TextView
        init{
            ivMovieImage = itemView.findViewById(R.id.ivMovieImage)
            tvMovieName = itemView.findViewById(R.id.tvMovieName)
        }

        fun setData(product: Item, position: Int){

            val title = product.original_title ?: "Unknown Title"
            val rating = product.vote_average ?: "N/A"
            tvMovieName.text = "$title ($rating)"

            Glide.with(ivMovieImage.context)
                .load("https://image.tmdb.org/t/p/w500${product.poster_path}")
                .placeholder(R.drawable.photo1)
                .error(R.drawable.photo2)
                .into(ivMovieImage)

        }


    }

}