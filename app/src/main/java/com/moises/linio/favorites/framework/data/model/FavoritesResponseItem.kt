package com.moises.linio.favorites.framework.data.model

import com.google.gson.annotations.SerializedName

data class FavoritesResponseItem(

    @field:SerializedName("owner")
    val owner: Owner? = null,

    @field:SerializedName("createdAt")
    val createdAt: String? = null,

    @field:SerializedName("default")
    val jsonMemberDefault: Boolean? = null,

    @field:SerializedName("visibility")
    val visibility: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("accessHash")
    val accessHash: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("products")
    val products: Map<String, FavoriteItem>? = null
)