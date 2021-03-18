package com.moises.linio.favorites.framework.util

import com.moises.linio.core.design.model.ProductView
import com.moises.linio.favorites.domain.model.FavoriteList
import com.moises.linio.favorites.domain.model.FavoriteProduct
import com.moises.linio.favorites.framework.data.mapper.FavoriteResponseItemToFavoriteListMapper
import com.moises.linio.favorites.framework.data.model.FavoritesResponseItem
import com.moises.linio.favorites.framework.ui.mapper.FavoriteProductToProductViewMapper

private val favoriteListMapper = FavoriteResponseItemToFavoriteListMapper()
private val favoriteProductMapper = FavoriteProductToProductViewMapper()

fun List<FavoritesResponseItem>.toFavoritesList() : List<FavoriteList> =
    favoriteListMapper.transformCollection(this)

fun List<FavoriteProduct>.toProductViewList(): List<ProductView> =
    favoriteProductMapper.transformCollection(this)