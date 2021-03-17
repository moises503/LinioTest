package com.moises.linio.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun providesHttpClient() : OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient().newBuilder().addInterceptor(interceptor).addInterceptor {
            val request = it.request()
            val builder = request.newBuilder()
                .addHeader(ACCEPT_HEADER, APPLICATION_JSON_VALUE)
                .addHeader(CONTENT_TYPE_HEADER, APPLICATION_JSON_VALUE)
                .method(request.method, request.body)
            it.proceed(builder.build())
        }.build()
    }

    @Provides
    @Singleton
    fun providesRetrofit(httpClient : OkHttpClient) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(URL_BASE)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private const val URL_BASE = "https://raw.githubusercontent.com/linio-mobile-devs/linio-test-files/main/"
    private const val ACCEPT_HEADER = "Accept"
    private const val CONTENT_TYPE_HEADER = "Content-Type"
    private const val APPLICATION_JSON_VALUE = "application/json"
}