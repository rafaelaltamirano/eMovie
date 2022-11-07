package com.example.emovie.ui.framework.di

import com.example.data.datasource.repository.MovieRepository
import com.example.data.datasource.repository.MoviesLocalSource
import com.example.data.datasource.repository.MoviesRemoteSource
import com.example.emovie.ui.framework.datasourceImp.movies.MoviesLocalSourceImp
import com.example.emovie.ui.framework.datasourceImp.movies.MoviesRemoteSourceImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun bindMoviesRemoteSource(imp: MoviesRemoteSourceImp): MoviesRemoteSource

    @Binds
    @Singleton
    abstract fun bindMoviesLocalSource(imp: MoviesLocalSourceImp): MoviesLocalSource


}