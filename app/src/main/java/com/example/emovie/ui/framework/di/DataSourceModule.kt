package com.example.emovie.ui.framework.di

import com.example.data.datasource.repository.MoviesRemoteSource
import com.example.data.datasource.repository.TopRatedMovieLocalSource
import com.example.data.datasource.repository.UpComingMoviesLocalSource
import com.example.emovie.ui.framework.datasourceImp.movies.MoviesRemoteSourceImp
import com.example.emovie.ui.framework.datasourceImp.movies.TopRatedMoviesLocalSourceImp
import com.example.emovie.ui.framework.datasourceImp.movies.UpComingMoviesLocalSourceImp
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
    abstract fun bindUpComingMoviesLocalSource(imp: UpComingMoviesLocalSourceImp): UpComingMoviesLocalSource

    @Binds
    @Singleton
    abstract fun bindTopRatedMoviesLocalSource(imp: TopRatedMoviesLocalSourceImp): TopRatedMovieLocalSource


}