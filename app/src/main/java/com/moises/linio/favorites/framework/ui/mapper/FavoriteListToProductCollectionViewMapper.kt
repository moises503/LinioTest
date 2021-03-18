package com.moises.linio.favorites.framework.ui.mapper

import com.moises.linio.core.arch.Mapper
import com.moises.linio.core.design.productcollection.ProductCollectionView
import com.moises.linio.favorites.domain.model.FavoriteList
import com.moises.linio.favorites.domain.model.FavoriteProduct

class FavoriteListToProductCollectionViewMapper : Mapper<FavoriteList, ProductCollectionView>() {
    override fun transform(value: FavoriteList): ProductCollectionView {
        return ProductCollectionView(
            name = value.name,
            size = value.products.size.toString(),
            productImages = getProductImages(value.products)
        )
    }

    private fun getProductImages(products: List<FavoriteProduct>): List<String> {
        val productImages : MutableList<String> = mutableListOf()
        products.take(3).forEach {
            productImages.add(it.image)
        }
        return productImages
    }
}