package com.moises.linio.favorites.framework.presentation

import com.moises.linio.favorites.domain.model.FavoriteList
import com.moises.linio.favorites.domain.model.FavoriteProduct

sealed class FavoriteViewState {
    data class Error(val message: String): FavoriteViewState()
    data class Success(
        val list: List<FavoriteList>,
        val productFavorites: List<FavoriteProduct>,
        val favoritesTotal: Int
    ): FavoriteViewState()
}