package com.walisaalam.class3.recyclerVew

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.walisaalam.class3.R

class ProductAdapter(val productlist: ArrayList<Product>): RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    var createViewHolderCount = 0
    var bindViewHolderCount = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.productitem,parent,false)
        val viewHolder = ProductViewHolder(view)
        createViewHolderCount++
        Log.i("RECYCLERVIEW","CreateViewHolder Count $createViewHolderCount")
        return viewHolder

        // Xml inflate
        // view create
        // viewHolder a pass
        // return viewHolder
    }

    override fun getItemCount(): Int {
        return productlist.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.setData(productlist[position],position)
        bindViewHolderCount++
        Log.d("RECYCLERVIEW","BindViewHolder Count $bindViewHolderCount")
    }
    class ProductViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val ivproductImage: ImageView
        val tvproductName: TextView
        init{
            ivproductImage = itemView.findViewById(R.id.ivProductImage)
            tvproductName = itemView.findViewById(R.id.tvProductName)
        }

        fun setData(product: Product,position: Int){
            if( position%3 == 0) ivproductImage.setImageResource(R.drawable.photo1)
            else ivproductImage.setImageResource(R.drawable.photo2)
            tvproductName.text = product.name
        }

    }
}