package com.example.productcatalogue

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductListAdapter(private val products: List<Product>, private val onClickListener: (Product) -> Unit) :
    RecyclerView.Adapter<ProductListAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(products[position])
    }

    override fun getItemCount() = products.size

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val productName: TextView = itemView.findViewById(R.id.product_name)
        private val productPrice: TextView = itemView.findViewById(R.id.product_price)

        fun bind(product: Product) {
            productName.text = product.name
            productPrice.text = itemView.context.getString(R.string.price_format, String.format("%.2f", product.price))
            itemView.setOnClickListener{
                onClickListener(product)
            }
//            itemView.setOnickListener {
//                onClickListener(product)
//            }

        }

    }
}
