package com.example.usecases

import com.example.data.datasource.repository.*
import com.example.usecases.datasourceFake.movieDetails
import com.example.usecases.datasourceFake.movies
import com.example.usecases.datasourceFake.videoDetails
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

import org.junit.jupiter.api.Test
import org.mockito.kotlin.*

@ExperimentalCoroutinesApi
class HomeCaseTest {

    private lateinit var moviesRemoteSource: MoviesRemoteSource
    private lateinit var upComingMoviesLocalSource: UpComingMoviesLocalSource
    private lateinit var topRatedMoviesLocalSource: TopRatedMovieLocalSource

    private lateinit var upComingMovieRepo: UpComingMovieRepository
    private lateinit var topRatedMovieRepo: TopRatedMovieRepository
    private lateinit var movieDetailsDao: MovieDetailsDao
    private lateinit var homeCase: HomeCase

    @BeforeEach
    fun setUp() {

        moviesRemoteSource = mock()
        upComingMoviesLocalSource = mock()
        topRatedMoviesLocalSource = mock()
        movieDetailsDao = mock()
        upComingMovieRepo = UpComingMovieRepository(moviesRemoteSource, upComingMoviesLocalSource)
        topRatedMovieRepo = TopRatedMovieRepository(moviesRemoteSource, topRatedMoviesLocalSource)
        homeCase = HomeCase(
            upComingMovieRepo = upComingMovieRepo,
            topRatedMovieRepo = topRatedMovieRepo,
            movieDetailsDao = movieDetailsDao
        )


    }

    @Test
    fun `requestUpcomingMovies() should be success if it return a list of movies `() =
        runBlockingTest {
            moviesRemoteSource.stub {
                onBlocking { requestUpcomingMovies() }.doReturn(movies)
            }

            val res = homeCase.requestUpcomingMovies()
            assertEquals(1, res.size)
        }

//    @Test
//    fun `requestUpcomingMovies() should be HttpException if it find exception `() =
//        runBlockingTest {
//            moviesRemoteSource.stub {
//                onBlocking { requestUpcomingMovies() }.doAnswer{
//                    throw HttpException(401, "test")
//                }
//            }
//
//            val res = homeCase.requestUpcomingMovies()
//            assertEquals(1, res.size)
//        }

    @Test
    fun `requestTopRatedMovies() should be success if it return a list of movies `() =
        runBlockingTest {
            moviesRemoteSource.stub {
                onBlocking { requestTopRatedMovies() }.doReturn(movies)
            }

            val res = homeCase.requestTopRatedMovies()
            assertEquals(1, res.size)
        }

    @Test
    fun `requestMovieDetails() should be success if it return a movieDetail `() =
        runBlockingTest {
            movieDetailsDao.stub {
                onBlocking { requestMovieDetails(any()) }.doReturn(movieDetails)
            }

            val res = homeCase.requestMovieDetails(any())
            assertEquals(movieDetails, res)
        }
    @Test
    fun `requestVideoDetails() should be success if it return a videoDetail `() =
        runBlockingTest {
            movieDetailsDao.stub {
                onBlocking { requestVideoDetails(any()) }.doReturn(videoDetails)
            }

            val res = homeCase.requestVideoDetails(any())
            assertEquals(1, res.size)
        }

}