package com.example.emovie.ui.framework.di

import com.example.usecases.HomeCase
import com.example.usecases.MainCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun providerMainCase(
    ): MainCase {
        return MainCase()
    }

    @Singleton
    @Provides
    fun providerHomeCase(
    ): HomeCase {
        return HomeCase(
        )
    }

//    @Singleton
//    @Provides
//    fun providerHomeCase(
//        tvShowRepo: TvShowsRepository
//    ) = HomeCase(tvShowRepo)
//

}