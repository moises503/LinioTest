package com.moises.linio.core.design.product

import com.moises.linio.core.design.product.model.ProductView

interface CardProductContract {
    interface Presenter {
        fun showProduct(productView: ProductView)
    }

    interface View {
        fun loadBackgroundImage(url: String)
        fun showOptionsIcons(list: List<Int>)
        fun hideOptionsIcons()
    }
}