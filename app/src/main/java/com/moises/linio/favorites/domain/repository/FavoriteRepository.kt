package com.moises.linio.favorites.domain.repository

import com.moises.linio.favorites.domain.model.FavoriteList
import kotlinx.coroutines.flow.Flow

interface FavoriteRepository {
    suspend fun recoverAllFavorites(): Flow<List<FavoriteList>>
}