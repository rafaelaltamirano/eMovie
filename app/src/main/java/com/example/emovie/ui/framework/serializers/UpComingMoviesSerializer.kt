package com.example.emovie.ui.framework.serializers
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.Serializer
import androidx.datastore.dataStore
import com.example.emovie.proto.UpcomingMovies.UpcomingMoviesProto
import java.io.InputStream
import java.io.OutputStream

object UpComingMoviesSerializer : Serializer<UpcomingMoviesProto> {

    override val defaultValue: UpcomingMoviesProto
        get() = UpcomingMoviesProto.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): UpcomingMoviesProto {
        return try {
            UpcomingMoviesProto.parseFrom(input)
        } catch (e: Exception) {
            UpcomingMoviesProto.getDefaultInstance()
        }
    }

    override suspend fun writeTo(t: UpcomingMoviesProto, output: OutputStream) {
        t.writeTo(output)
    }

}

val Context.upComingMoviesStore: DataStore<UpcomingMoviesProto> by dataStore(
    fileName = "UpcomingMovies.proto",
    serializer = UpComingMoviesSerializer
)