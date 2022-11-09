package com.example.emovie.ui.screen.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import com.example.emovie.R
import com.example.emovie.ui.theme.Secondary

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