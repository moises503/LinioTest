package com.moises.linio.favorites.framework.data.model

import com.google.gson.annotations.SerializedName

data class FavoriteItem(
    @field:SerializedName("image")
    val image: String? = null,

    @field:SerializedName("freeShipping")
    val freeShipping: Boolean? = null,

    @field:SerializedName("imported")
    val imported: Boolean? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("active")
    val active: Boolean? = null,

    @field:SerializedName("wishListPrice")
    val wishListPrice: Int? = null,

    @field:SerializedName("conditionType")
    val conditionType: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("linioPlusLevel")
    val linioPlusLevel: Int? = null,

    @field:SerializedName("slug")
    val slug: String? = null,

    @field:SerializedName("url")
    val url: String? = null
)