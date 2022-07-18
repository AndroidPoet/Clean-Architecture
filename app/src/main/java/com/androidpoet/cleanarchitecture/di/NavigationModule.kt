package com.androidpoet.cleanarchitecture.di

import com.androidpoet.cleanarchitecture.navigator.ComposeNavigator
import com.androidpoet.cleanarchitecture.navigator.MoviesComposeNavigator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NavigationModule {

    @Binds
    @Singleton
    abstract fun provideComposeNavigator(moviesComposeNavigator: MoviesComposeNavigator): ComposeNavigator
}