package com.example.weatherapplication.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
object UseCaseModule {

//    @Singleton
//    @Provides
//    fun provideRegisterUserUseCase(dataSource: UserDataSource) = RegisterUserUseCase(dataSource)
//
//
//    @Singleton
//    @Provides
//    fun provideUserDetailsUseCase(dataSource: UserDataSource)= UserDetailsUseCase(dataSource)
}