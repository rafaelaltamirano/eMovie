package com.example.emovie.ui.router

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.emovie.ui.router.RouterDir.*
import com.example.emovie.ui.screen.details.DetailsModel
import com.example.emovie.ui.screen.details.DetailsScreen
import com.example.emovie.ui.screen.home.HomeModel
import com.example.emovie.ui.screen.home.HomeScreen
import com.example.emovie.ui.screen.main.MainModel
import com.example.emovie.ui.screen.splash.SplashScreen

@Composable
fun Router(mainModel: MainModel) {

    val navController = rememberNavController()

    NavHost(navController = navController,
        startDestination = if (mainModel.state.showSplash) SPLASH.route else DETAIL.route) {

        composable(SPLASH.route) { SplashScreen() }

        composable(HOME.route) {
            val homeModel = hiltViewModel<HomeModel>()
            HomeScreen(homeModel,mainModel,navController)
        }


        composable(DETAIL.route) {
            val detailsModel = hiltViewModel<DetailsModel>()
            DetailsScreen()
        }

    }
}

