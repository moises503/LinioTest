package com.moises.linio.favorites.domain.model


data class FavoriteProduct(
    val image: String,
    val freeShipping: Boolean,
    val imported: Boolean,
    val name: String,
    val active: Boolean,
    val wishListPrice: Int,
    val conditionType: String,
    val id: Int,
    val linioPlusLevel: Int,
    val slug: String,
    val url: String
)