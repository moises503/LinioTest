package com.moises.linio.favorites.framework.presentation

import com.moises.linio.favorites.domain.model.FavoriteList

sealed class FavoriteViewState {
    data class Error(val message: String): FavoriteViewState()
    data class Success(val list: List<FavoriteList>): FavoriteViewState()
}