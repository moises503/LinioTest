package com.moises.linio.core.design.product.model

import androidx.annotation.DrawableRes

data class ProductView (
    val imageUrl : String,
    @DrawableRes
    val icons : List<Int>
)