package com.example.emovie.ui.screen.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.usecases.MainCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainModel @Inject constructor(
    private val mainCase: MainCase
) : ViewModelWithStatus() {

    init {
        viewModelScope.launch {
            delay(2000)
            setShowSplash(false)
        }
    }

    var state by mutableStateOf(MainState())
        private set

    private fun setShowSplash(showSplash: Boolean) {
        state = state.copy(showSplash = showSplash)
    }

}
