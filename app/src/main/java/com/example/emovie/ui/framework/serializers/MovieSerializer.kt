package com.example.emovie.ui.framework.serializers
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.Serializer
import androidx.datastore.dataStore
import com.example.emovie.proto.Movies.Movie
import java.io.InputStream
import java.io.OutputStream

object MovieSerializer : Serializer<Movie> {

    override val defaultValue: Movie
        get() = Movie.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): Movie {
        return try {
            Movie.parseFrom(input)
        } catch (e: Exception) {
            Movie.getDefaultInstance()
        }
    }

    override suspend fun writeTo(t: Movie, output: OutputStream) {
        t.writeTo(output)
    }

}

val Context.moviesStore: DataStore<Movie> by dataStore(
    fileName = "Movie.proto",
    serializer = MovieSerializer
)