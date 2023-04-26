package com.example.productcatalogue

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ProductListFragment : Fragment(R.layout.fragment_product_list) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val productList = listOf(
            Product("Product 1", 10.0),
            Product("Product 2", 15.0),
            Product("Product 3", 20.0)
        )

        val recyclerView = view.findViewById<RecyclerView>(R.id.product_list)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        recyclerView.adapter = ProductListAdapter(productList) { product ->
            val bundle = Bundle().apply { putParcelable("product", product) }
            val detailFragment = ProductDetailFragment().apply { arguments = bundle }
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, detailFragment)
                .addToBackStack(null)
                .commit()
        }
    }

}