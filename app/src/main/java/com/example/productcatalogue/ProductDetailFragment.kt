package com.example.productcatalogue

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment

class ProductDetailFragment : Fragment(R.layout.fragment_product_detail) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val product = requireArguments().getParcelable<Product>("product")

        view.findViewById<TextView>(R.id.product_name).text = product?.name
        view.findViewById<TextView>(R.id.product_price).text = product?.price.toString()
    }
}