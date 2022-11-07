package com.example.emovie.ui.framework.di

import android.content.Context
import androidx.datastore.core.DataStore
import com.example.emovie.proto.Movies.Movies
import com.example.emovie.ui.framework.serializers.moviesStore
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
    fun providerMoviesStore(
        @ApplicationContext context: Context
    ): DataStore<Movies> = context.moviesStore
}