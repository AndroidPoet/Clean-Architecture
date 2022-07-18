package com.androidpoet.cleanarchitecture.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
//    @Provides
//    @Singleton
//    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
//        return Room.inMemoryDatabaseBuilder(
//            context,
//            AppDatabase::class.java,
//        ).build()
//    }

}