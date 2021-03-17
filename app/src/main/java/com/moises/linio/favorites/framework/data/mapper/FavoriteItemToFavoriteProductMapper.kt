package com.moises.linio.favorites.framework.data.mapper

import com.moises.linio.core.arch.Mapper
import com.moises.linio.favorites.domain.model.FavoriteProduct
import com.moises.linio.favorites.framework.data.model.FavoriteItem

class FavoriteItemToFavoriteProductMapper : Mapper<FavoriteItem, FavoriteProduct>() {
    override fun transform(value: FavoriteItem): FavoriteProduct {
        return FavoriteProduct(
            image = value.image.orEmpty(),
            freeShipping = value.freeShipping ?: false,
            imported = value.imported ?: false,
            name = value.name.orEmpty(),
            active = value.active ?: false,
            wishListPrice = value.wishListPrice ?: 0,
            conditionType = value.conditionType.orEmpty(),
            id = value.id ?: 0,
            linioPlusLevel = value.linioPlusLevel ?: 0,
            slug = value.slug.orEmpty(),
            url = value.url.orEmpty()
        )
    }
}