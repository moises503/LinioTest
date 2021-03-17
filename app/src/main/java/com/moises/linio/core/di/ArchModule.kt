package com.moises.linio.core.di

import com.moises.linio.core.arch.DispatcherProvider
import com.moises.linio.core.arch.DispatcherProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ArchModule {
    @Provides
    @Singleton
    fun providesDispatcher() : DispatcherProvider = DispatcherProviderImpl()
}