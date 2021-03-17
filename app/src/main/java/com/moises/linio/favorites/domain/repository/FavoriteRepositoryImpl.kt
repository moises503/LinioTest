package com.moises.linio.favorites.domain.repository

import com.moises.linio.core.arch.DispatcherProvider
import com.moises.linio.favorites.data.FavoriteDataSource
import com.moises.linio.favorites.domain.model.FavoriteList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class FavoriteRepositoryImpl @Inject constructor(
    private val favoriteDataSource: FavoriteDataSource,
    private val dispatcherProvider: DispatcherProvider
) : FavoriteRepository {
    override suspend fun recoverAllFavorites(): Flow<List<FavoriteList>> = flow {
        emit(favoriteDataSource.recoverAllFavorites())
    }.flowOn(dispatcherProvider.ioDispatcher())
}