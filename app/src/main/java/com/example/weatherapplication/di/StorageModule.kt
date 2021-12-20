package com.example.weatherapplication.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
object StorageModule {

//    @Singleton
//    @Provides
//    fun provideRepository(service: UserService): UserRepository = UserRepositoryImpl(service)
//
//
//    @Singleton
//    @Provides
//    fun provideDataSource(repository: UserRepository): UserDataSource = UserDataSourceImpl(repository)
}