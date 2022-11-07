package com.example.emovie.ui.framework.serializers
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.Serializer
import androidx.datastore.dataStore
import com.example.emovie.proto.Movies.Movies
import java.io.InputStream
import java.io.OutputStream

object MovieSerializer : Serializer<Movies> {

    override val defaultValue: Movies
        get() = Movies.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): Movies {
        return try {
            Movies.parseFrom(input)
        } catch (e: Exception) {
            Movies.getDefaultInstance()
        }
    }

    override suspend fun writeTo(t: Movies, output: OutputStream) {
        t.writeTo(output)
    }

}

val Context.moviesStore: DataStore<Movies> by dataStore(
    fileName = "Movies.proto",
    serializer = MovieSerializer
)