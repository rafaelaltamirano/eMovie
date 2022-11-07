package com.example.emovie.ui.screen.details

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.emovie.R
import com.example.emovie.ui.screen.components.DetailCard
import com.example.emovie.ui.theme.Primary
import com.example.emovie.ui.theme.Secondary
import com.example.emovie.ui.theme.Tertiary
import com.example.emovie.utils.AppConstants
import com.example.emovie.utils.AppConstants.LARGE_IMAGE_URL
import java.util.*

@Composable
fun DetailsScreesn(
    imageRes: String = "$LARGE_IMAGE_URL/xKCpH9xF4JReTL5NsWm4wtafPQP.jpg",
) {
    val density = LocalDensity.current
    val width = remember { mutableStateOf(0f) }
    val height = remember { mutableStateOf(0f) }

    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageRes)
            .crossfade(true)
            .build(),
        contentDescription = "",
        modifier = Modifier
            .fillMaxSize()
            .drawWithCache {
                val gradient = Brush.verticalGradient(
                    colors = listOf(Color.Transparent, Color.Black),
                    startY = size.height / 3,
                    endY = size.height
                )
                onDrawWithContent {
                    drawContent()
                    drawRect(gradient, blendMode = BlendMode.Multiply)
                }
            }
    )
}


@Composable
fun DetailsScreen(
    imageRes: String = "$LARGE_IMAGE_URL/xKCpH9xF4JReTL5NsWm4wtafPQP.jpg",
    modifier: Modifier = Modifier
) {

    val title: String = "Her"
    val year: String = "2013"
    val language: String = "es"
    val rating: String = "8.0"
    val type: String = "Hearfelt , Romance , scigi , drama"

    val loremTitle = "MOVIE PLOT"
    val lorem =
        "In a near future, a lonely writer develops an unlikely relationship with an operating system designed to meet his every need."


    BoxWithConstraints(
        Modifier
            .fillMaxSize()
    ) {
        val aspectRatio = maxWidth / maxHeight
        Box {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imageRes)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                placeholder = painterResource(R.drawable.ic_photo),
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
            Column(modifier = Modifier.fillMaxSize()) {
                Spacer(modifier = Modifier.weight(1f))
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(modifier = Modifier.fillMaxSize(),Arrangement.Center,Alignment.CenterHorizontally) {
                        Text(
                            text = title,
                            style = MaterialTheme.typography.h1,
                            color = Secondary,
                            modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.gap4)),
                            textAlign = TextAlign.Center,
                        )
                        DetailCard(
                            icon = R.drawable.ic_star_fill
                        )
                    }
                }

            }
        }
    }
}







