package com.moises.linio.favorites.framework.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moises.linio.core.arch.ScreenState
import com.moises.linio.core.assets.ResourceManager
import com.moises.linio.favorites.domain.model.FavoriteList
import com.moises.linio.favorites.domain.model.FavoriteProduct
import com.moises.linio.favorites.domain.repository.FavoriteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val favoriteRepository: FavoriteRepository,
    private val resourceManager: ResourceManager
) : ViewModel() {
    private var _favoriteState = MutableLiveData<ScreenState<FavoriteViewState>>()
    val favoriteState: LiveData<ScreenState<FavoriteViewState>> get() = _favoriteState

    fun recoverAllFavoriteList() {
        viewModelScope.launch {
            favoriteRepository.recoverAllFavorites().onStart {
                _favoriteState.postValue(ScreenState.Loading)
            }.catch {
                _favoriteState.postValue(
                    ScreenState.Render(
                        FavoriteViewState.Error(
                            it.localizedMessage
                                ?: resourceManager.providesStringMessage(identifier = "connection_error")
                        )
                    )
                )
            }.collect {
                _favoriteState.postValue(
                    ScreenState.Render(
                        getFavorites(it)
                    )
                )
            }
        }
    }

    private fun getFavorites(list: List<FavoriteList>): FavoriteViewState.Success {
        var total = 0
        val favorites = mutableListOf<FavoriteProduct>()
        list.forEach {
            total += it.products.size
            favorites.addAll(it.products)
        }
        return FavoriteViewState.Success(list, favorites, total)
    }
}