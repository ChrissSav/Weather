package com.example.weather_application.di

import android.app.Application
import androidx.room.Room
import com.example.weather_application.data.WeatherDataSourceImpl
import com.example.weather_application.data.WeatherRepository
import com.example.weather_application.domain.WeatherDataSource
import com.example.weather_application.domain.room.WeatherDatabase
import com.example.weather_application.domain.room.dao.DirectDao
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
    fun provideRepository(service: WeatherService, directDao: DirectDao): WeatherRepository = WeatherRepositoryImpl(service, directDao)


    @Singleton
    @Provides
    fun provideDataSource(repository: WeatherRepository): WeatherDataSource = WeatherDataSourceImpl(repository)

    @Singleton
    @Provides
    fun provideDatabase(application: Application): WeatherDatabase =
        Room.databaseBuilder(application.applicationContext, WeatherDatabase::class.java, "weather_db")
            //  .addMigrations(MIGRATION_1_2)
            .build()

    @Singleton
    @Provides
    fun providesProductDao(weatherDatabase: WeatherDatabase): DirectDao =
        weatherDatabase.directDao()

}