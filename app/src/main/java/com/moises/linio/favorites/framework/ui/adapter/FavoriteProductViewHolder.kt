package com.moises.linio.favorites.framework.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.moises.linio.core.design.CardProductView
import com.moises.linio.core.design.model.ProductView

class FavoriteProductViewHolder(val view: CardProductView): RecyclerView.ViewHolder(view) {
    fun bind(productView: ProductView) {
        view.setProduct(productView)
    }
}