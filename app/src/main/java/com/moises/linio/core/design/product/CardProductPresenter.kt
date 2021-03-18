package com.moises.linio.core.design.product

import com.moises.linio.core.design.product.model.ProductView

class CardProductPresenter(
    private val view: CardProductContract.View
) : CardProductContract.Presenter {

    override fun showProduct(productView: ProductView) {
        loadRemoteImage(productView)
        loadIcons(productView)
    }

    private fun loadIcons(productView: ProductView) {
        if (productView.icons.isNotEmpty()) {
            view.showOptionsIcons(productView.icons)
        } else {
            view.hideOptionsIcons()
        }
    }

    private fun loadRemoteImage(productView: ProductView) {
        view.loadBackgroundImage(productView.imageUrl)
    }
}