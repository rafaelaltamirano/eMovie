package com.example.emovie.ui.screen.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.emovie.R
import com.example.emovie.ui.router.RouterDir
import com.example.emovie.ui.router.RouterDir.*
import com.example.emovie.ui.screen.components.*
import com.example.emovie.ui.screen.home.MovieFilterTypes.*
import com.example.emovie.ui.screen.main.MainModel
import com.example.emovie.ui.screen.main.Status
import com.example.emovie.ui.screen.main.Status.*
import com.example.emovie.ui.theme.Primary
import com.example.emovie.ui.theme.Secondary
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun HomeScreen(
    model: HomeModel,
    mainModel: MainModel,
    navController: NavHostController
) {


    model.status?.also {
        val (status) = it
        when (status) {
            NETWORK_ERROR -> mainModel.setNetworkErrorStatus(it)
            ERROR -> mainModel.setErrorStatus(it)
            INTERNET_CONNECTION_ERROR -> mainModel.setInternetConnectionError(it)
            else -> { }
        }
        model.clearStatus()
    }


    val state = model.state
    val lifecycle = LocalLifecycleOwner.current

    DisposableEffect(lifecycle) {

        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_DESTROY) mainModel.logOut()
            if (event == Lifecycle.Event.ON_START) model.start()
        }

        lifecycle.lifecycle.addObserver(observer)

        onDispose {
            lifecycle.lifecycle.removeObserver(observer)
        }

    }

    Scaffold(
        topBar = { TopAppBar() },
        backgroundColor = Primary,
    ) {

        if (state.loadingTopRated && state.loadingUpComing) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 20.dp, end = 20.dp, top = 60.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                CircularProgressIndicator(
                    Modifier
                        .width(37.dp)
                        .height(40.dp)
                        .fillMaxSize(),
                )
            }
        } else {
            SwipeRefresh(
                state = rememberSwipeRefreshState(state.loadingSwipe),
                onRefresh = {
                    model.setSelectedFilter(SPANISH.url)
                    model.requestTopRatedMovies()
                    model.requestUpComingMovies()
                    model.requestTopRatedByFilter(SPANISH)
                    model.setLoadingSwipe(false)
                },
                indicator = { state, trigger ->
                    SwipeRefreshIndicator(
                        state = state,
                        refreshTriggerDistance = trigger,
                        contentColor = Primary,
                    )
                },
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Column(
                    Modifier
                        .verticalScroll(rememberScrollState())
                        .padding(dimensionResource(R.dimen.gap4))
                ) {
                    Headline(stringResource(R.string.upcoming))
                    HorizontalList(items = state.upcomingMovies,
                        onClick = {
                            model.requestSelectedMovie(it)
                            navController.navigate(DETAIL.route)
                        }
                    )
                    Headline(stringResource(R.string.topRated))
                    HorizontalList(items = state.topRatedMovies,
                        onClick = {
                            model.requestSelectedMovie(it)
                            navController.navigate(DETAIL.route)
                        })
                    Headline(stringResource(R.string.recommendations))
                    FilterCategoryList(
                        onClickItem = {
                            model.requestTopRatedByFilter(it)
                        },
                        categoryList = state.category,
                        onSelectionChange = { model.setSelectedFilter(it) },
                        selectedOption = state.selectedFilter
                    )
                    VerticalList(items = state.topRatedByFilterMovies,
                        onClick = {
                            model.requestSelectedMovie(it)
                            navController.navigate(DETAIL.route)
                        })
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(viewModel(), viewModel(), rememberNavController())
}
