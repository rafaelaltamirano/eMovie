package com.example.emovie.ui.framework.di


import com.example.data.datasource.repository.MovieRepository
import com.example.data.datasource.repository.MoviesLocalSource
import com.example.data.datasource.repository.MoviesRemoteSource
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
    fun providerMovieRepository(
        remote: MoviesRemoteSource,
        local: MoviesLocalSource
    ): MovieRepository {
        return MovieRepository(remote, local)
    }
}