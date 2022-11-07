package com.example.emovie.ui.screen.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Movie
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

    init {
        requestUpComingMovies()
        requestTopRatedMovies()
        requestTopRatedByFilter(SPANISH)
    }

    private fun setLoading(loading: Boolean) {
        state = state.copy(loading = loading)
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


    private fun requestUpComingMovies() = viewModelScope.launch {
        try {
            setLoading(true)
            withContext(IO) { homeCase.requestUpcomingMovies() }.also {
                setUpcomingMovies(it)
            }
        } catch (e: Exception) {
            handleNetworkError(e)
        } finally {
            setLoading(false)
        }
    }

    private fun requestTopRatedMovies() = viewModelScope.launch {
        try {
            setLoading(true)
            withContext(IO) { homeCase.requestTopRatedMovies() }.also {
                setTopRatedMovies(it)
            }
        } catch (e: Exception) {
            handleNetworkError(e)
        } finally {
            setLoading(false)
        }
    }

    fun requestTopRatedByFilter(filter: MovieFilterTypes) = viewModelScope.launch {
        try {
            setLoading(true)
            withContext(IO) { homeCase.requestTopRatedMovies() }.also { movieList ->
                val filterMovieList = when (filter) {
                    FROM_1993 -> { movieList.filter { movie -> movie.releaseDate.subSequence(0,4).toString() == filter.url } }
                    SPANISH -> { movieList.filter { x -> x.originalLanguage == filter.url } }
                }
                if (filterMovieList.count() > 5) setTopRatedByFilterMovies(filterMovieList.take(6))
                else setTopRatedByFilterMovies(filterMovieList)
            }
        } catch (e: Exception) {
            handleNetworkError(e)
        } finally {
            setLoading(false)
        }
    }
}