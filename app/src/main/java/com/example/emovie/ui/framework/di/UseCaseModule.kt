package com.example.emovie.ui.framework.di

import com.example.data.datasource.repository.MovieDetailsDao
import com.example.data.datasource.repository.TopRatedMovieRepository
import com.example.data.datasource.repository.UpComingMovieRepository
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
        upComingMovieRepo: UpComingMovieRepository,
        topRatedMovieRepo: TopRatedMovieRepository
    ): MainCase {
        return MainCase(upComingMovieRepo, topRatedMovieRepo)
    }

    @Singleton
    @Provides
    fun providerHomeCase(
        upComingMovieRepo: UpComingMovieRepository,
        topRatedMovieRepo: TopRatedMovieRepository,
         movieDetailsDao: MovieDetailsDao
    ): HomeCase {
        return HomeCase(upComingMovieRepo, topRatedMovieRepo,movieDetailsDao)
    }

}