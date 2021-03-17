package com.moises.linio.favorites.framework.data

import com.moises.linio.favorites.framework.data.model.FavoritesResponseItem
import retrofit2.http.GET

interface FavoritesEndPoint {
    @GET("wishlist.json")
    suspend fun attemptRecoverFavorites(): List<FavoritesResponseItem>
}