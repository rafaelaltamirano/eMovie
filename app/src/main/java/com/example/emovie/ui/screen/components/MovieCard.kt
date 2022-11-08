package com.example.emovie.ui.screen.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.domain.model.Movie
import com.example.emovie.R
import com.example.emovie.utils.AppConstants

@Composable
fun MovieCard(
    modifier: Modifier = Modifier
        .height(180.dp)
        .width(138.dp),
    item: Movie,
    onClick: (() -> Unit),
) {
    Card(
        modifier = modifier
            .padding(dimensionResource(R.dimen.gap2))
            .shadow(dimensionResource(R.dimen.gap2))
            .clickable(
                onClick = { onClick() },
            ),
                shape = MaterialTheme . shapes . medium,
        elevation = dimensionResource(R.dimen.gap2)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(AppConstants.LARGE_IMAGE_URL + item.poster)
                .crossfade(true)
                .build(),
            contentDescription = null,
            placeholder = painterResource(R.drawable.ic_photo),
            modifier = Modifier
                .fillMaxWidth()
                .height(136.dp),
            contentScale = ContentScale.Crop,
        )
    }
}
