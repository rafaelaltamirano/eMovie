package com.example.emovie.ui.framework.datasourceImp.movies.topRatedMovies

import androidx.datastore.core.DataStore
import com.example.data.datasource.repository.TopRatedMovieLocalSource
import com.example.data.datasource.repository.UpComingMoviesLocalSource
import com.example.domain.model.Movie
import com.example.emovie.proto.TopRatedMovies.TopRatedMovieProto
import com.example.emovie.proto.TopRatedMovies.TopRatedMoviesProto
import kotlinx.coroutines.flow.firstOrNull
import javax.inject.Inject

class TopRatedMoviesLocalSourceImp @Inject constructor(
    private val store: DataStore<TopRatedMoviesProto>
) : TopRatedMovieLocalSource {

    override suspend fun save(t: List<Movie>) {
        store.updateData {
            TopRatedMoviesProto
                .newBuilder()
                .addAllMovie( t.map { it.toProtoTR()} )
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

fun TopRatedMovieProto.toEntity() = Movie(
    id = id,
    name = name,
    poster = poster,
    rating = rating,
    releaseDate = releaseDate,
    originalLanguage = originalLanguage
)

fun Movie.toProtoTR(): TopRatedMovieProto = TopRatedMovieProto.newBuilder()
    .setId(id)
    .setName(name)
    .setPoster(poster)
    .setRating(rating)
    .setReleaseDate(releaseDate)
    .setOriginalLanguage(originalLanguage)
    .build()
