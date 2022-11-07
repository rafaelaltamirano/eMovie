package com.example.emovie.ui.framework.datasourceImp.movies

import androidx.datastore.core.DataStore
import com.example.data.datasource.repository.MoviesLocalSource
import com.example.domain.model.Movie
import com.example.emovie.proto.Movies.Movie as MovieProto
import com.example.emovie.proto.Movies.Movies as MoviesProto
import kotlinx.coroutines.flow.firstOrNull
import javax.inject.Inject

class MoviesLocalSourceImp @Inject constructor(
    private val store: DataStore<MoviesProto>
) : MoviesLocalSource {

//    override suspend fun save(t: List<Movie>) {
//        store.updateData { t.toProto() }
//    }

    override suspend fun save(t: List<Movie>) {
        store.updateData {
            MoviesProto
                .newBuilder()
                .addAllMovie( t.map { it.toProto() } )
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

fun MovieProto.toEntity() = Movie(
    id = id,
    name = name,
    poster = poster,
    rating = rating


)

fun Movie.toProto(): MovieProto = MovieProto.newBuilder()
    .setId(id)
    .setName(name)
    .setPoster(poster)
    .setRating(rating)
    .build()
