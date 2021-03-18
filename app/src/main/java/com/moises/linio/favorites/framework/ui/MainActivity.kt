package com.moises.linio.favorites.framework.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.moises.linio.R
import com.moises.linio.core.arch.ScreenState
import com.moises.linio.core.ui.*
import com.moises.linio.core.ui.EqualSpaceItemDecoration
import com.moises.linio.databinding.ActivityMainBinding
import com.moises.linio.favorites.framework.presentation.FavoriteViewState
import com.moises.linio.favorites.framework.presentation.FavoritesViewModel
import com.moises.linio.favorites.framework.ui.adapter.FavoriteCollectionAdapter
import com.moises.linio.favorites.framework.ui.adapter.FavoriteProductAdapter
import com.moises.linio.favorites.framework.util.toProductCollectionList
import com.moises.linio.favorites.framework.util.toProductViewList
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val favoriteViewModel: FavoritesViewModel by viewModels()
    private val productFavoritesAdapter: FavoriteProductAdapter = FavoriteProductAdapter()
    private val favoriteCollectionAdapter: FavoriteCollectionAdapter = FavoriteCollectionAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        attachObservers()
        bindViews()
        favoriteViewModel.recoverAllFavoriteList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.favorites_menu, menu)
        return true
    }

    private fun attachObservers() {
        favoriteViewModel.favoriteState.observe(this, Observer {
            renderScreenState(it)
        })
    }

    private fun bindViews() {
        setAppToolbar(
            toolbar = binding.appBarHomeService.toolbar,
            toolbarTitle = binding.appBarHomeService.toolbarTitle,
            title = getString(R.string.favorites_title)
        )
        binding.productsRecyclerView.apply {
            adapter = productFavoritesAdapter
            layoutManager = GridLayoutManager(this@MainActivity, 2)
        }
        binding.favoritesCollectionRecyclerView.apply {
            adapter = favoriteCollectionAdapter
            addItemDecoration(EqualSpaceItemDecoration(resources.getDimensionPixelSize(R.dimen.dimen_4dp)))
        }
    }

    private fun renderScreenState(screenState: ScreenState<FavoriteViewState>) {
        when(screenState) {
            is ScreenState.Loading -> showLoader()
            is ScreenState.Render -> renderFavoriteInformation(screenState.data)
        }
    }

    private fun renderFavoriteInformation(favoriteState: FavoriteViewState) {
        hideLoader()
        when (favoriteState) {
            is FavoriteViewState.Success -> renderFavoritesList(favoriteState)
            is FavoriteViewState.Error -> showError(favoriteState.message)
        }
    }

    private fun renderFavoritesList(data : FavoriteViewState.Success) {
        binding.allFavoritesTextView.text = String.format(getString(R.string.all_my_favorites), data.favoritesTotal)
        productFavoritesAdapter.updateDataSet(data.productFavorites.toProductViewList())
        favoriteCollectionAdapter.updateDataSet(data.list.toProductCollectionList())
    }

    private fun showError(message: String) {
        toast(message)
    }

    private fun showLoader() {
        binding.contentLayout.gone()
        binding.loaderProgressBar.visible()
    }

    private fun hideLoader() {
        binding.loaderProgressBar.gone()
        binding.contentLayout.visible()
    }
}