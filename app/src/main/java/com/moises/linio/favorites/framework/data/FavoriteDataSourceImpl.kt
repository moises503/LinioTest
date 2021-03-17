package com.moises.linio.favorites.framework.data

import com.moises.linio.favorites.data.FavoriteDataSource
import com.moises.linio.favorites.domain.model.FavoriteList
import com.moises.linio.favorites.framework.util.toFavoritesList
import javax.inject.Inject

class FavoriteDataSourceImpl @Inject constructor(
    private val favoritesEndPoint: FavoritesEndPoint
) : FavoriteDataSource {
    override suspend fun recoverAllFavorites(): List<FavoriteList> {
        return favoritesEndPoint.attemptRecoverFavorites().toFavoritesList()
    }
}