package com.moises.linio.favorites.framework.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.moises.linio.R
import com.moises.linio.core.design.productcollection.ProductCollectionView
import com.moises.linio.core.ui.inflate

class FavoriteCollectionAdapter(
    private val productCollections : MutableList<ProductCollectionView> = mutableListOf()
) : RecyclerView.Adapter<FavoriteCollectionViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteCollectionViewHolder =
        FavoriteCollectionViewHolder(parent.inflate(R.layout.product_collection))

    override fun getItemCount(): Int = productCollections.size

    override fun onBindViewHolder(holder: FavoriteCollectionViewHolder, position: Int) {
        holder.bind(productCollections[position])
    }

    fun updateDataSet(list: List<ProductCollectionView>) {
        productCollections.clear()
        productCollections.addAll(list)
        notifyDataSetChanged()
    }
}