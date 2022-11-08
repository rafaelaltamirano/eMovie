package com.example.emovie.ui.screen.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.emovie.R
import com.example.emovie.ui.screen.components.BackRow
import com.example.emovie.ui.screen.components.BulletList
import com.example.emovie.ui.screen.components.DetailCard
import com.example.emovie.ui.theme.Primary
import com.example.emovie.ui.theme.Secondary
import com.example.emovie.utils.AppConstants.ORIGINAL_IMAGE_URL
import com.example.emovie.utils.roundToOneDecimalPlace


@Composable
fun DetailsScreen(
    homeModel: HomeModel,
    navController: NavController
) {
    val state = homeModel.state
    Scaffold(
        topBar = { BackRow(navController = navController) },
    ) {
        BoxWithConstraints(
            Modifier
                .fillMaxSize()
        ) {
            val aspectRatio = maxWidth / maxHeight
            Box {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(ORIGINAL_IMAGE_URL + state.movieDetails?.poster)
                        .crossfade(true)
                        .build(),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .scale(maxOf(aspectRatio, 1.5f), maxOf(1 / aspectRatio, 1.5f))
                        .drawWithCache {
                            val gradient = Brush.radialGradient(
                                colors = listOf(Color.Transparent, Primary),
                            )
                            onDrawWithContent {
                                drawContent()
                                drawRect(gradient, blendMode = BlendMode.Multiply)
                            }
                        },
                    contentScale = ContentScale.Crop,
                )
            }
        }


        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.weight(0.8f))
            Box(
                modifier = Modifier
                    .weight(1.2f)
                    .fillMaxWidth()
                    .padding(horizontal = dimensionResource(R.dimen.gap4)),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    Arrangement.Center,
                    Alignment.CenterHorizontally
                ) {
                    Text(
                        text = state.movieDetails?.name ?: "",
                        style = MaterialTheme.typography.h1,
                        color = Secondary,
                        modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.gap4)),
                        textAlign = TextAlign.Center,
                    )

                    Row {
                        DetailCard(text = state.movieDetails?.releaseDate ?: "")
                        DetailCard(
                            text = state.movieDetails?.originalLanguage ?: "",
                            modifier = Modifier.padding(horizontal = 8.dp)
                        )
                        DetailCard(
                            text = state.movieDetails?.rating?.roundToOneDecimalPlace()
                                .toString(),
                            icon = R.drawable.ic_star_fill
                        )
                    }
                    BulletList(list = state.movieDetails?.genres)

                    OutlinedButton(
                        colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color.Transparent),
                        border = BorderStroke(1.dp, Secondary),
                        shape = MaterialTheme.shapes.medium,
                        modifier = Modifier.fillMaxWidth(),
                        onClick = { }
                    ) {
                        Text(
                            text = stringResource(R.string.watch_trailer),
                            style = MaterialTheme.typography.body2,
                            color = Secondary,
                            modifier = Modifier.padding(dimensionResource(R.dimen.gap2))
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(vertical = dimensionResource(R.dimen.gap4))
                            .verticalScroll(rememberScrollState())
                    ) {

                        Text(
                            text = stringResource(R.string.watch_trailer).uppercase(),
                            style = MaterialTheme.typography.body2,
                            color = Secondary,
                        )
                        Text(
                            text = state.movieDetails?.overview ?: "",
                            style = MaterialTheme.typography.body1,
                            fontSize = 14.sp,
                            color = Secondary,
                        )

                    }

                }

            }

        }
    }
}





