package com.example.emovie.ui.screen.components

import android.content.Intent
import android.net.Uri
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.emovie.R
import com.example.emovie.ui.theme.Secondary

@Composable
fun OutlineButton (onClick:()->Unit,
                    @StringRes text: Int,
                    modifier: Modifier = Modifier.fillMaxWidth()){

    OutlinedButton(
        colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color.Transparent),
        border = BorderStroke(1.dp, Secondary),
        shape = MaterialTheme.shapes.medium,
        modifier = modifier.fillMaxWidth(),
        onClick = { onClick() }
    ) {
        Text(
            text = stringResource(text),
            style = MaterialTheme.typography.body2,
            color = Secondary,
            modifier = Modifier.padding(dimensionResource(R.dimen.gap2))
        )
    }
}