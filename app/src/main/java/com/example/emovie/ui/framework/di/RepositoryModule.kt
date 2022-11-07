package com.example.emovie.ui.framework.di


import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

//    @Singleton
//    @Provides
//    fun providerTvShowsRepository(
//        remote: TvShowsRemoteSource,
//        mobiDatabase: MubiDatabase
//    ): TvShowsRepository {
//        return TvShowsRepository(remote, mobiDatabase)
//    }
}