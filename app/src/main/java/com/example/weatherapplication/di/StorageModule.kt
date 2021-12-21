package com.example.weatherapplication.di

import com.example.weatherapplication.data.WeatherDataSourceImpl
import com.example.weatherapplication.data.WeatherRepository
import com.example.weatherapplication.domain.WeatherDataSource
import com.example.weatherapplication.framework.WeatherRepositoryImpl
import com.example.weatherapplication.framework.WeatherService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object StorageModule {

    @Singleton
    @Provides
    fun provideRepository(service: WeatherService): WeatherRepository = WeatherRepositoryImpl(service)


    @Singleton
    @Provides
    fun provideDataSource(repository: WeatherRepository): WeatherDataSource = WeatherDataSourceImpl(repository)
}