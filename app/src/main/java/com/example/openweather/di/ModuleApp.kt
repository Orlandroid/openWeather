package com.example.openweather.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)

object ModuleApp {

    @Singleton
    @Provides
    fun provideStrin(): String = "Hola mundo"

}