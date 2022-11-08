package com.example.emovie.ui.screen.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Movie
import com.example.domain.model.MovieDetails
import com.example.domain.model.VideoDetails
import com.example.emovie.ui.screen.home.MovieFilterTypes.*
import com.example.emovie.ui.screen.main.ViewModelWithStatus
import com.example.usecases.HomeCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeModel @Inject constructor(
    private val homeCase: HomeCase
) : ViewModelWithStatus() {
    var state by mutableStateOf(HomeState())
        private set

    fun start() {
        loadUpComingMoviesFromCache()
        loadTopRatedMoviesFromCache()
        requestTopRatedByFilter(SPANISH)
        requestUpComingMovies()
        requestTopRatedMovies()
        setSelectedFilter(SPANISH.url)
    }

    private fun setUpcomingMovies(upcomingMovies: List<Movie>) {
        state = state.copy(upcomingMovies = upcomingMovies)
    }

    private fun setTopRatedMovies(topRatedMovies: List<Movie>) {
        state = state.copy(topRatedMovies = topRatedMovies)
    }

    private fun setTopRatedByFilterMovies(topRatedByFilterMovies: List<Movie>) {
        state = state.copy(topRatedByFilterMovies = topRatedByFilterMovies)
    }

    private fun setMovieDetails(movieDetails: MovieDetails) {
        state = state.copy(movieDetails = movieDetails)
    }

    private fun setVideoDetails(videoDetails: List<VideoDetails>) {
        state = state.copy(videoDetails = videoDetails)
    }

     fun setSelectedFilter(selectedFilter: String) {
        state = state.copy(selectedFilter = selectedFilter)
    }

    private fun loadUpComingMoviesFromCache() = homeCase.loadUpComingMovies().also(::setUpcomingMovies)

    private fun loadTopRatedMoviesFromCache() = homeCase.loadTopRatedMovies().also(::setTopRatedMovies)


    fun setLoadingUpComing(loadingUpComing: Boolean) {
        state = state.copy(loadingUpComing = loadingUpComing)
    }

    fun setLoadingTopRated(loadingTopRated: Boolean) {
        state = state.copy(loadingTopRated = loadingTopRated)
    }

    fun setLoadingSwipe(loadingSwipe: Boolean) {
        state = state.copy(loadingSwipe = loadingSwipe)
    }

    fun requestUpComingMovies() = viewModelScope.launch {
        try {
            setLoadingUpComing(true)
            withContext(IO) { homeCase.requestUpcomingMovies() }.also {
                setUpcomingMovies(it)
            }
        } catch (e: Exception) {
            handleNetworkError(e)
        } finally {
            setLoadingUpComing(false)
        }
    }

     fun requestTopRatedMovies() = viewModelScope.launch {
        try {
            setLoadingTopRated(true)
            withContext(IO) { homeCase.requestTopRatedMovies() }.also {
                setTopRatedMovies(it)
            }
        } catch (e: Exception) {
            handleNetworkError(e)
        } finally {
            setLoadingTopRated(false)
        }
    }

    fun requestTopRatedByFilter(filter: MovieFilterTypes) = viewModelScope.launch {
        try {

                val filterMovieList = when (filter) {
                    FROM_1993 -> { state.topRatedMovies.filter { movie -> movie.releaseDate == filter.url } }
                    SPANISH -> { state.topRatedMovies.filter { x -> x.originalLanguage == filter.url } }
                }
                if (filterMovieList.count() > 5) setTopRatedByFilterMovies(filterMovieList.take(6))
                else setTopRatedByFilterMovies(filterMovieList)
        } catch (e: Exception) {
            handleNetworkError(e)
        } finally {
            setLoadingUpComing(false)
        }
    }

    fun requestSelectedMovie(movie: Movie) = viewModelScope.launch {
        try {
            setLoadingTopRated(true)
            withContext(IO) { homeCase.requestMovieDetails(movie.id) }.also {
                setMovieDetails(it) }
            withContext(IO) { homeCase.requestVideoDetails(movie.id) }.also {
                setVideoDetails(it) }
        } catch (e: Exception) {
            handleNetworkError(e)
        } finally {
            setLoadingUpComing(false)
        }
    }
}