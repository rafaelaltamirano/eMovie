package com.example.emovie.ui.screen.components

import android.provider.MediaStore
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.W600
import androidx.compose.ui.text.font.FontWeight.Companion.W800
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.emovie.R
import com.example.emovie.ui.theme.Primary
import com.example.emovie.ui.theme.Secondary
import com.example.emovie.ui.theme.Yellow

@Composable
fun DetailCard(
    @DrawableRes icon: Int? = null,
    text: String = "2013",
    modifier: Modifier = Modifier
) {

    val shape = RoundedCornerShape(8.dp)

    Row(
        modifier = modifier
            .background(
                color = if (icon != null) Yellow else Secondary,
                shape = shape
            )
            .padding(dimensionResource(R.dimen.gap2)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        if (icon != null) {
            Icon(
                painter = painterResource(icon),
                contentDescription = "icon card",
                tint = Primary,
                modifier = Modifier
                    .height(10.dp)
                    .width(10.dp)
                    .align(CenterVertically)
            )
        }
            Text(
                text = text,
                color = Primary,
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Center,
                fontWeight = (if (icon != null) W600 else W800),
                modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.gap2)),
                maxLines = 1,
            )
    }
}