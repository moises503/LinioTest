package com.moises.linio.favorites.framework.data.model

import com.google.gson.annotations.SerializedName

data class Owner(
    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("email")
    val email: String? = null,

    @field:SerializedName("linioId")
    val linioId: String? = null
)