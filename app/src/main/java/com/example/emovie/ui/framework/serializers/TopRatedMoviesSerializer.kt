package com.example.emovie.ui.framework.serializers

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.Serializer
import androidx.datastore.dataStore
import com.example.emovie.proto.TopRatedMovies.TopRatedMoviesProto
import java.io.InputStream
import java.io.OutputStream

object TopRatedMoviesSerializer : Serializer<TopRatedMoviesProto> {

    override val defaultValue: TopRatedMoviesProto
        get() = TopRatedMoviesProto.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): TopRatedMoviesProto {
        return try {
            TopRatedMoviesProto.parseFrom(input)
        } catch (e: Exception) {
            TopRatedMoviesProto.getDefaultInstance()
        }
    }

    override suspend fun writeTo(t: TopRatedMoviesProto, output: OutputStream) {
        t.writeTo(output)
    }

}

val Context.topRatedMoviesStore: DataStore<TopRatedMoviesProto> by dataStore(
    fileName = "TopRatedMovies.proto",
    serializer = TopRatedMoviesSerializer
)