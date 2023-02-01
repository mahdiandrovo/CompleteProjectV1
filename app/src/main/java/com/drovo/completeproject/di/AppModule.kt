package com.drovo.completeproject.di

import com.drovo.completeproject.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module //to make this module
@InstallIn(SingletonComponent::class) //valid for whole application
object AppModule {

    @Provides
    fun providesUrl(): String = "https://jsonplaceholder.typicode.com"

    @Provides
    @Singleton
    fun providesApiService(url: String): ApiService =
        Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)


}