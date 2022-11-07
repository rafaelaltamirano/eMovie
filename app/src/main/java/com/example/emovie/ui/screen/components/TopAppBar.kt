package com.example.emovie.ui.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.emovie.R
import com.example.emovie.ui.theme.Secondary
import com.example.emovie.utils.dashedBorder

@Composable
fun TopAppBar() {

    TopAppBar() {
        Row(
            Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier.dashedBorder(1.dp, color = Secondary, radius = 0.dp),
                contentAlignment = Alignment.Center,

                ) {

                Image(
                    painter = painterResource(R.drawable.ic_logo),
                    contentDescription = "logo",
                    modifier = Modifier
                        .padding(dimensionResource(R.dimen.gap2))
                        .width(110.dp)
                        .height(35.dp),
                )
            }
        }
    }

}

@Preview
@Composable
fun PreviewTopBar() {
    TopAppBar()
}