package com.example.usecases.datasourceFake

import com.example.data.datasource.repository.*
import com.example.domain.model.Genres
import com.example.domain.model.Movie
import com.example.domain.model.MovieDetails
import com.example.domain.model.VideoDetails

class MoviesRemoteSourceFakeImp : MoviesRemoteSource {


    override suspend fun requestUpcomingMovies(): List<Movie> = movies

    override suspend fun requestTopRatedMovies(): List<Movie> = movies

}

class UpComingMoviesLocalSourceFakeImp : UpComingMoviesLocalSource {

    private var upComingMovies: List<Movie> = emptyList()

    override suspend fun save(t: List<Movie>) {
        upComingMovies = t
    }

    override suspend fun load(): List<Movie> = upComingMovies

    override suspend fun clear() {
        upComingMovies = emptyList()
    }

}


class TopRatedMoviesLocalSourceFakeImp : TopRatedMovieLocalSource {

    private var upComingMovies: List<Movie> = emptyList()

    override suspend fun save(t: List<Movie>) {
        upComingMovies = t
    }

    override suspend fun load(): List<Movie> = upComingMovies

    override suspend fun clear() {
        upComingMovies = emptyList()
    }

}

val movie = Movie(
    id = 1,
    poster = "asdasda.jpg",
    name = "Bob Esponja",
    rating = 9.12f,
    releaseDate = "2007-10-10",
    originalLanguage = "en",
)

val movieDetails = MovieDetails(
    id = 1,
    poster = "asdasda.jpg",
    name = "Bob Esponja",
    rating = 9.12f,
    releaseDate = "2007-10-10",
    originalLanguage = "en",
    genres = emptyList(),
   overview = "lorem itsum ..."
)

val videoDetail = VideoDetails(
   key = "1832193"
)


val videoDetails = listOf(videoDetail)
val movies = listOf(movie)


val upComingMovieRepoFake = UpComingMovieRepository(
    remote = MoviesRemoteSourceFakeImp(),
    local = UpComingMoviesLocalSourceFakeImp()
)

val topRatedMovieRepoFake = TopRatedMovieRepository(
    remote = MoviesRemoteSourceFakeImp(),
    local = TopRatedMoviesLocalSourceFakeImp()
)