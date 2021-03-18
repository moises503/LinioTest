package com.moises.linio.favorites.framework.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.moises.linio.core.design.product.CardProductView
import com.moises.linio.core.design.product.model.ProductView

class FavoriteProductAdapter(
    private val products: MutableList<ProductView> = mutableListOf()
) : RecyclerView.Adapter<FavoriteProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteProductViewHolder =
        FavoriteProductViewHolder(
            CardProductView(
                parent.context
            )
        )

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: FavoriteProductViewHolder, position: Int) {
        holder.bind(products[position])
    }

    fun updateDataSet(list: List<ProductView>) {
        products.clear()
        products.addAll(list)
        notifyDataSetChanged()
    }
}