package com.example.emovie.ui.screen.home

import android.hardware.Camera
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.emovie.R
import com.example.emovie.ui.screen.components.*
import com.example.emovie.ui.theme.Primary
import com.example.emovie.ui.theme.Secondary
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(model: HomeModel, navController: NavHostController) {
    val state = model.state

    Scaffold(
        topBar = { TopAppBar() },
        backgroundColor = Primary,
    ) {
        Column(
            Modifier
                .verticalScroll(rememberScrollState())
                .padding(dimensionResource(R.dimen.gap4))
        ) {
            Headline(stringResource(R.string.upcoming))
            HorizontalList(items = state.upcomingMovies)
            Headline(stringResource(R.string.topRated))
            HorizontalList(items = state.topRatedMovies)
            Headline(stringResource(R.string.recommendations))
            FilterCategoryList(
                onClickItem = { model.requestTopRatedByFilter(it) },
                state.category
            )
            VerticalList(items = state.topRatedByFilterMovies)
        }
    }
}


@Composable
fun Headline(title: String) {
    Text(
        modifier = Modifier.padding(vertical = dimensionResource(R.dimen.gap4)),
        text = title,
        style = MaterialTheme.typography.h3,
        color = Secondary,
        maxLines = 1,
        textAlign = TextAlign.Left
    )
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(viewModel(), rememberNavController())
}
