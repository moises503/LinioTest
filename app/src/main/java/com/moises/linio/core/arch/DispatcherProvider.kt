package com.moises.linio.core.arch

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherProvider {
    fun ioDispatcher(): CoroutineDispatcher
    fun defaultDispatcher(): CoroutineDispatcher
    fun mainDispatcher(): CoroutineDispatcher
}