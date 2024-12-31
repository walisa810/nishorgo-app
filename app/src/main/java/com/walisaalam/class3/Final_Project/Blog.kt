package com.walisaalam.class3.Final_Project

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.walisaalam.class3.databinding.ItemBlogBinding

class BlogAdapter(private val items: List<BlogPost>) :
    RecyclerView.Adapter<BlogAdapter.BlogViewHolder>() {

    inner class BlogViewHolder(private val binding: ItemBlogBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(blogPost: BlogPost) {
            // Bind text data to the views
            binding.title.text = blogPost.title
            binding.author.text = blogPost.author
            binding.date.text = blogPost.date
            binding.content.text = blogPost.content

            // Load the image using Glide if the URL is valid
            Glide.with(binding.img.context)
                .load(blogPost.imageurl)
                .into(binding.img)

            // Handle "Read More" button click
            binding.readbutton.setOnClickListener {
                // Use the context from the binding's root view
                val context = binding.root.context
                val intent = Intent(context, ArticleDetailActivity::class.java).apply {
                    // Passing the necessary data to the ArticleDetailActivity
                    putExtra("title", blogPost.title)
                    putExtra("content", blogPost.content)
                    putExtra("author", blogPost.author)
                    putExtra("date", blogPost.date)
                    putExtra("imageUrl", blogPost.imageurl)
                }
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        val binding = ItemBlogBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BlogViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}
