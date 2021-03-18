package com.moises.linio.core.design.product.adapter

import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.RecyclerView
import com.moises.linio.R
import com.moises.linio.core.ui.inflate
import com.moises.linio.databinding.ProductOptionCornerIconBinding
import com.moises.linio.databinding.ProductOptionIconBinding

class OptionIconAdapter(
    private val icons: MutableList<Int> = mutableListOf()
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when(viewType) {
            IconType.TOP_CORNER.value -> OptionTopCornerIconViewHolder(parent.inflate(R.layout.product_option_corner_icon))
            else -> OptionIconViewHolder(parent.inflate(R.layout.product_option_icon))
        }

    override fun getItemCount(): Int = icons.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is OptionTopCornerIconViewHolder -> holder.bind(icons[position])
            is OptionIconViewHolder -> holder.bind(icons[position])
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            IconType.TOP_CORNER.value
        } else {
            IconType.NORMAL.value
        }
    }

    fun updateDataSet(list : List<Int>) {
        icons.clear()
        icons.addAll(list)
        notifyDataSetChanged()
    }

    inner class OptionIconViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ProductOptionIconBinding.bind(view)

        fun bind(@DrawableRes icon: Int) {
            binding.productIconImageView.setImageResource(icon)
        }
    }

    inner class OptionTopCornerIconViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ProductOptionCornerIconBinding.bind(view)

        fun bind(@DrawableRes icon: Int) {
            binding.productIconImageView.setImageResource(icon)
        }
    }

    enum class IconType(val value : Int) {
        NORMAL(0),
        TOP_CORNER(1)
    }
}