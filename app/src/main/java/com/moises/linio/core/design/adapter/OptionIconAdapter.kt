package com.moises.linio.core.design.adapter

import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.RecyclerView
import com.moises.linio.R
import com.moises.linio.core.ui.inflate
import com.moises.linio.databinding.ProductOptionIconBinding

class OptionIconAdapter(
    private val icons: MutableList<Int> = mutableListOf()
) : RecyclerView.Adapter<OptionIconAdapter.OptionIconViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionIconViewHolder =
        OptionIconViewHolder(parent.inflate(R.layout.product_option_icon))

    override fun getItemCount(): Int = icons.size

    override fun onBindViewHolder(holder: OptionIconViewHolder, position: Int) {
        holder.bind(icons[position])
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
}