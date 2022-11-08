package com.example.emovie.ui.router

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.emovie.ui.router.RouterDir.*
import com.example.emovie.ui.screen.home.MovieDetails
import com.example.emovie.ui.screen.home.HomeModel
import com.example.emovie.ui.screen.home.HomeScreen
import com.example.emovie.ui.screen.main.MainModel
import com.example.emovie.ui.screen.splash.SplashScreen

@Composable
fun Router(mainModel: MainModel) {

    val navController = rememberNavController()
    val homeModel = hiltViewModel<HomeModel>()

    NavHost(
        navController = navController,
        startDestination = if (mainModel.state.showSplash) SPLASH.route else HOME.route
    ) {

        composable(SPLASH.route) { SplashScreen() }

        composable(HOME.route) {

            HomeScreen(
                model = homeModel,
                mainModel = mainModel,
                navController = navController
            )
        }


        composable(DETAIL.route) {
            MovieDetails(
                homeModel = homeModel,
                mainModel = mainModel,
                navController = navController
            )
        }

    }
}

