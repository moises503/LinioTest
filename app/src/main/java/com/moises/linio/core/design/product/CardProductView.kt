package com.moises.linio.core.design.product

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.moises.linio.R
import com.moises.linio.core.design.product.adapter.OptionIconAdapter
import com.moises.linio.core.design.product.model.ProductView
import com.moises.linio.core.ui.gone
import com.moises.linio.core.ui.visible
import com.moises.linio.databinding.ProductCardBinding
import com.squareup.picasso.Picasso

@SuppressLint("UseCompatLoadingForDrawables")
class CardProductView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attributeSet, defStyleAttr),
    CardProductContract.View {

    private val binding: ProductCardBinding =
        ProductCardBinding.bind(View.inflate(context, R.layout.product_card, this))
    private val presenter: CardProductContract.Presenter =
        CardProductPresenter(this)
    private val optionIconsAdapter = OptionIconAdapter()

    init {
        layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            resources.getDimensionPixelSize(R.dimen.dimen_174dp)
        )
        background = context.getDrawable(R.color.white_two)
        binding.iconsRecyclerView.apply {
            adapter = optionIconsAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }

    fun setProduct(view: ProductView) {
        presenter.showProduct(view)
    }

    override fun loadBackgroundImage(url: String) {
        Picasso.get().load(url).into(binding.productImageView)
    }

    override fun showOptionsIcons(list: List<Int>) {
        binding.iconsRecyclerView.visible()
        optionIconsAdapter.updateDataSet(list)
    }

    override fun hideOptionsIcons() {
        binding.iconsRecyclerView.gone()
    }
}