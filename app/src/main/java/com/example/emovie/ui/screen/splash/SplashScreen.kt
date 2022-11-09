package com.example.emovie.ui.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.emovie.R
import com.example.emovie.ui.theme.Primary
import com.example.emovie.ui.theme.Secondary
import com.example.emovie.ui.theme.Tertiary
import com.example.emovie.utils.dashedBorder

@Composable
fun SplashScreen() {



    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Primary,
                        Tertiary
                    )
                )
            ),
    contentAlignment = Alignment.Center
    ) {

        Box(
            modifier = Modifier.dashedBorder(1.dp, color = Secondary, radius = 0.dp),
            contentAlignment = Alignment.Center
        ) {

            Image(
                painter = painterResource(R.drawable.ic_logo),
                contentDescription = "logo",
                modifier = Modifier.padding(dimensionResource(R.dimen.gap2))
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SplashScreen()
}