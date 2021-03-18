package com.moises.linio.core.design

import com.moises.linio.core.design.model.ProductView

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