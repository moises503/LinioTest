package com.moises.linio.favorites.framework.di

import com.moises.linio.core.arch.DispatcherProvider
import com.moises.linio.favorites.data.FavoriteDataSource
import com.moises.linio.favorites.domain.repository.FavoriteRepository
import com.moises.linio.favorites.domain.repository.FavoriteRepositoryImpl
import com.moises.linio.favorites.framework.data.FavoriteDataSourceImpl
import com.moises.linio.favorites.framework.data.FavoritesEndPoint
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FavoriteModule {
    @Provides
    @Singleton
    fun providesFavoriteEndPoint(retrofit: Retrofit): FavoritesEndPoint =
        retrofit.create(FavoritesEndPoint::class.java)

    @Provides
    @Singleton
    fun providesFavoriteDataSource(favoritesEndPoint: FavoritesEndPoint): FavoriteDataSource =
        FavoriteDataSourceImpl(favoritesEndPoint)

    @Provides
    @Singleton
    fun providesFavoriteRepository(
        favoriteDataSource: FavoriteDataSource,
        dispatcherProvider: DispatcherProvider
    ): FavoriteRepository =
        FavoriteRepositoryImpl(favoriteDataSource, dispatcherProvider)
}