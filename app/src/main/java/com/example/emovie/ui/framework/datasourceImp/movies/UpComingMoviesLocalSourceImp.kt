package com.example.emovie.ui.framework.datasourceImp.movies

import androidx.datastore.core.DataStore
import com.example.data.datasource.repository.UpComingMoviesLocalSource
import com.example.domain.model.Movie
import com.example.emovie.proto.UpcomingMovies.UpcomingMovieProto
import com.example.emovie.proto.UpcomingMovies.UpcomingMoviesProto
import kotlinx.coroutines.flow.firstOrNull
import javax.inject.Inject

class UpComingMoviesLocalSourceImp @Inject constructor(
    private val store: DataStore<UpcomingMoviesProto>
) : UpComingMoviesLocalSource {

    override suspend fun save(t: List<Movie>) {
        store.updateData {
            UpcomingMoviesProto
                .newBuilder()
                .addAllMovie( t.map { it.toProtoUC() } )
                .build()
        }
    }

    override suspend fun load(): List<Movie> {
        return store.data.firstOrNull()
            ?.movieList
            ?.map { it.toEntity() }
            ?: emptyList()
    }

    override suspend fun clear() {
        store.updateData {
            it.toBuilder().clear().build()
        }
    }

}

fun UpcomingMovieProto.toEntity() = Movie(
    id = id,
    name = name,
    poster = poster,
    rating = rating,
    releaseDate = releaseDate,
    originalLanguage = originalLanguage
 )

fun Movie.toProtoUC(): UpcomingMovieProto = UpcomingMovieProto.newBuilder()
    .setId(id)
    .setName(name)
    .setPoster(poster)
    .setRating(rating)
    .setReleaseDate(releaseDate)
    .setOriginalLanguage(originalLanguage)
    .build()
