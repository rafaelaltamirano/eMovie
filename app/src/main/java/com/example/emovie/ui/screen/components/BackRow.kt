package com.example.emovie.ui.screen.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.emovie.R
import com.example.emovie.ui.theme.Secondary


@Composable
fun BackRow(
    navController: NavController? = null,
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = dimensionResource(R.dimen.gap4)),
        verticalAlignment = Alignment.CenterVertically
    ) {

        navController?.let {
            IconButton(onClick = { it.popBackStack() }) {
                Icon(
                    painterResource(R.drawable.ic_back_button),
                    contentDescription = "back",
                    tint = Secondary,
                )
            }
        }
    }
}
