package com.example.emovie.ui.framework.di

import android.content.Context
import androidx.datastore.core.DataStore
import com.example.emovie.proto.UpcomingMovies.UpcomingMoviesProto
import com.example.emovie.proto.TopRatedMovies.TopRatedMoviesProto
import com.example.emovie.ui.framework.serializers.topRatedMoviesStore
import com.example.emovie.ui.framework.serializers.upComingMoviesStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object LocalStoreModule {
    @Singleton
    @Provides
    fun providerUpComingMoviesStore(
        @ApplicationContext context: Context
    ): DataStore<UpcomingMoviesProto> = context.upComingMoviesStore

    @Singleton
    @Provides
    fun providerTopRatedMoviesStore(
        @ApplicationContext context: Context
    ): DataStore<TopRatedMoviesProto> = context.topRatedMoviesStore
}