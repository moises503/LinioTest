package com.moises.linio.favorites.framework.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.moises.linio.R
import com.moises.linio.core.arch.ScreenState
import com.moises.linio.core.ui.toast
import com.moises.linio.favorites.domain.model.FavoriteList
import com.moises.linio.favorites.framework.presentation.FavoriteViewState
import com.moises.linio.favorites.framework.presentation.FavoritesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val favoriteViewModel: FavoritesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        attachObservers()
        favoriteViewModel.recoverAllFavoriteList()
    }

    private fun attachObservers() {
        favoriteViewModel.favoriteState.observe(this, Observer {
            renderScreenState(it)
        })
    }

    private fun renderScreenState(screenState: ScreenState<FavoriteViewState>) {
        when(screenState) {
            is ScreenState.Loading -> {}
            is ScreenState.Render -> {
                renderFavoriteInformation(screenState.data)
            }
        }
    }

    private fun renderFavoriteInformation(favoriteState: FavoriteViewState) {
        when (favoriteState) {
            is FavoriteViewState.Success -> {
                renderFavoritesList(favoriteState.list)
            }
            is FavoriteViewState.Error -> {
                showError(favoriteState.message)
            }
        }
    }

    private fun renderFavoritesList(list: List<FavoriteList>) {
        applicationContext.toast(list.toString())
    }

    private fun showError(message: String) {
        applicationContext.toast(message)
    }
}