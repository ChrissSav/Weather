package com.example.weather_application.di

import com.example.weather_application.data.WeatherDataSourceImpl
import com.example.weather_application.data.WeatherRepository
import com.example.weather_application.domain.WeatherDataSource
import com.example.weather_application.framework.WeatherRepositoryImpl
import com.example.weather_application.framework.WeatherService
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