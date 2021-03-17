package com.moises.linio.favorites.data

import com.moises.linio.favorites.domain.model.FavoriteList

interface FavoriteDataSource {
    suspend fun recoverAllFavorites(): List<FavoriteList>
}