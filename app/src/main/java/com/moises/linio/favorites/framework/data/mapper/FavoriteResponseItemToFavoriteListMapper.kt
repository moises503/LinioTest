package com.moises.linio.favorites.framework.data.mapper

import com.moises.linio.core.arch.Mapper
import com.moises.linio.favorites.domain.model.FavoriteList
import com.moises.linio.favorites.domain.model.FavoriteProduct
import com.moises.linio.favorites.domain.model.OwnerList
import com.moises.linio.favorites.framework.data.model.FavoriteItem
import com.moises.linio.favorites.framework.data.model.FavoritesResponseItem
import com.moises.linio.favorites.framework.data.model.Owner

class FavoriteResponseItemToFavoriteListMapper : Mapper<FavoritesResponseItem, FavoriteList>() {
    private val ownerMapper = OwnerToOwnerListMapper()
    private val favoriteProductMapper = FavoriteItemToFavoriteProductMapper()

    override fun transform(value: FavoritesResponseItem): FavoriteList {
        return FavoriteList(
            owner = getOwner(value.owner),
            createdAt = value.createdAt.orEmpty(),
            jsonMemberDefault = value.jsonMemberDefault ?: false,
            visibility = value.visibility.orEmpty(),
            name = value.name.orEmpty(),
            description = value.description.orEmpty(),
            accessHash = value.accessHash.orEmpty(),
            id = value.id ?: 0,
            products = getProducts(value.products)
        )
    }

    private fun getProducts(products: Map<String, FavoriteItem>?): List<FavoriteProduct> {
        return products.orEmpty().values.asIterable().map {
            favoriteProductMapper.transform(it)
        }
    }

    private fun getOwner(owner: Owner?): OwnerList {
        return owner?.let {
            ownerMapper.transform(it)
        } ?: OwnerList()
    }
}