package com.example.emovie.ui.framework.di


import com.example.data.datasource.repository.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providerTopRatedRepository(
        remote: MoviesRemoteSource,
        local: TopRatedMovieLocalSource
    ): TopRatedMovieRepository {
        return TopRatedMovieRepository(remote, local)
    }

    @Singleton
    @Provides
    fun providerUpComingRepository(
        remote: MoviesRemoteSource,
        local: UpComingMoviesLocalSource
    ): UpComingMovieRepository {
        return UpComingMovieRepository(remote, local)
    }
}