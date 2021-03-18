package com.moises.linio.favorites.framework.ui.mapper

import com.moises.linio.R
import com.moises.linio.core.arch.Mapper
import com.moises.linio.core.design.model.ProductView
import com.moises.linio.favorites.domain.model.FavoriteProduct

class FavoriteProductToProductViewMapper : Mapper<FavoriteProduct, ProductView>() {
    override fun transform(value: FavoriteProduct): ProductView {
        return ProductView(
            imageUrl = value.image,
            icons = getIcons(value)
        )
    }

    private fun getIcons(value: FavoriteProduct): List<Int> {
        val icons = mutableListOf<Int>()
        getLinioPlusIcon(value)?.let {
            icons.add(it)
        }
        getConditionTypeIcon(value)?.let {
            icons.add(it)
        }
        getImportedIcon(value)?.let {
            icons.add(it)
        }
        getFreeShippingIcon(value)?.let {
            icons.add(it)
        }
        return icons
    }

    private fun getLinioPlusIcon(value: FavoriteProduct): Int? {
        return when (value.linioPlusLevel) {
            1 -> R.drawable.ic_nd_ic_plus_30
            2 -> R.drawable.ic_nd_ic_plus_48_30
            else -> null
        }
    }

    private fun getConditionTypeIcon(value: FavoriteProduct): Int? {
        return when (value.conditionType) {
            REFURBISHED_CONDITION -> R.drawable.ic_nd_ic_refurbished_30
            NEW_CONDITION -> R.drawable.ic_nd_ic_new_30
            else -> null
        }
    }

    private fun getImportedIcon(value: FavoriteProduct): Int? {
        return when (value.imported) {
            true -> R.drawable.ic_nd_ic_international_30
            else -> null
        }
    }

    private fun getFreeShippingIcon(value: FavoriteProduct): Int? {
        return when (value.freeShipping) {
            true -> R.drawable.ic_nd_ic_free_shipping_30
            else -> null
        }
    }

    companion object {
        const val REFURBISHED_CONDITION = "refurbished"
        const val NEW_CONDITION = "new"
    }
}