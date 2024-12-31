package com.walisaalam.class3.recyclerVew

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.walisaalam.class3.R

class DifferentProductAdapter(val productlist: ArrayList<Product>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var createViewHolderCount = 0
    var bindViewHolderCount = 0

    val itemTypeRegular = 1
    val itemTypeHeader = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        createViewHolderCount++
        Log.i("RECYCLERVIEW","create viewholder count $createViewHolderCount")

        if ( viewType == itemTypeHeader ){
            val view = inflater.inflate(R.layout.productitem2, parent, false)
            return HeaderViewHolder(view)

        } else {
            val view = inflater.inflate(R.layout.productitem, parent, false)
            return ProductViewHolder(view)

        }

        // Xml inflate
        // view create
        // viewHolder a pass
        // return viewHolder

    }

    override fun getItemViewType(position: Int): Int {
        return if (position%5 == 0) itemTypeHeader else itemTypeRegular
    }

    override fun getItemCount(): Int {
        return productlist.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if ( holder is ProductViewHolder){
            holder.setData(productlist[position],position)
            bindViewHolderCount++
        }else if( holder is HeaderViewHolder){

            holder.setData(position)
            bindViewHolderCount++
        }
        Log.d("RECYCLERVIEW","bind viewholder count $bindViewHolderCount")
        holder.itemView.setOnClickListener{
            Toast.makeText(holder.itemView.context, "Item Clicked Position $position",Toast.LENGTH_LONG).show()
        }

    }
    class ProductViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val ivproductImage: ImageView
        val tvproductName: TextView
        init{
            ivproductImage = itemView.findViewById(R.id.ivProductImage)
            tvproductName = itemView.findViewById(R.id.tvProductName)
        }

        fun setData(product: Product, position: Int){
            tvproductName.text = product.name
            if( position%3 == 0) ivproductImage.setImageResource(R.drawable.baseline_attach_email_24)
            else ivproductImage.setImageResource(R.drawable.baseline_assignment_ind_24)
        }

    }
    class HeaderViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvheaderName: TextView

        init {
            tvheaderName = itemView.findViewById(R.id.tvHeader)
        }

        fun setData(position: Int) {
            tvheaderName.text = "Sorry! The product Number $position is not available"
        }
    }

}