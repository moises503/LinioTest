package com.moises.linio.favorites.framework.util

import com.moises.linio.favorites.domain.model.FavoriteList
import com.moises.linio.favorites.framework.data.mapper.FavoriteResponseItemToFavoriteListMapper
import com.moises.linio.favorites.framework.data.model.FavoritesResponseItem

private val favoriteListMapper = FavoriteResponseItemToFavoriteListMapper()

fun List<FavoritesResponseItem>.toFavoritesList() : List<FavoriteList> =
    favoriteListMapper.transformCollection(this)