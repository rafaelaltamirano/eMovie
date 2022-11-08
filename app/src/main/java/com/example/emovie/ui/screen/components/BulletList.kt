package com.example.emovie.ui.screen.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.domain.model.Genres
import com.example.emovie.R
import com.example.emovie.ui.theme.Secondary

@Composable
fun BulletList(
    modifier: Modifier = Modifier.padding(vertical = dimensionResource(R.dimen.gap4)),
    list: List<Genres>?
) {
    LazyRow(
        modifier = modifier
    ) {
        items(list?.size ?: 0) {
            Row(
                Modifier.padding(2.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (list?.indexOf(list[it]) != 0) {
                    Canvas(
                        modifier = Modifier
                            .padding(start = 8.dp, end = 8.dp)
                            .size(6.dp)
                    ) {
                        drawCircle(Secondary)
                    }
                }
                Text(
                    text = list?.get(it)?.name ?: "",
                    fontSize = 12.sp,
                    style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Center,
                    color = Secondary
                )
            }
        }
    }
}