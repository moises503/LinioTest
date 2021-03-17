package com.moises.linio.favorites.domain.model

data class FavoriteList(
    val owner: OwnerList,
    val createdAt: String,
    val jsonMemberDefault: Boolean,
    val visibility: String,
    val name: String,
    val description: String,
    val accessHash: String,
    val id: Int,
    val products: List<FavoriteProduct>
)