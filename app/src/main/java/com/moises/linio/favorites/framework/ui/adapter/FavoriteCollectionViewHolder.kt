package com.moises.linio.favorites.framework.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.moises.linio.core.design.productcollection.CardImageView
import com.moises.linio.core.design.productcollection.ProductCollectionView
import com.moises.linio.core.ui.visible
import com.moises.linio.databinding.ProductCollectionBinding
import com.squareup.picasso.Picasso
import java.lang.IllegalArgumentException

class FavoriteCollectionViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = ProductCollectionBinding.bind(view)
    private val cardImageViews = mutableListOf<CardImageView>()

    private fun attachCardImageViews() {
        cardImageViews.add(CardImageView(
            binding.firstImageView,
            binding.firstImageCardView
        ))
        cardImageViews.add(CardImageView(
            binding.secondImageView,
            binding.secondImageCardView
        ))
        cardImageViews.add(CardImageView(
            binding.thirdImageView,
            binding.thirdImageCardView
        ))
    }

    fun bind(productCollectionView: ProductCollectionView) {
        attachCardImageViews()
        binding.collectionNameTextView.text = productCollectionView.name
        binding.collectionSizeTextView.text = productCollectionView.size
        if (productCollectionView.productImages.size > 3) {
            throw IllegalArgumentException("You must provide only 3 items")
        } else {
            var cardPosition = 0
            productCollectionView.productImages.forEach {
                cardImageViews[cardPosition].cardView.visible()
                Picasso.get().load(it).into(cardImageViews[cardPosition].imageView)
                cardPosition++
            }
        }
    }
}