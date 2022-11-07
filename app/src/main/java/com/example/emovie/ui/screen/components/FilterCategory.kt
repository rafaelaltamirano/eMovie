package com.example.emovie.ui.screen.components

import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.emovie.R
import com.example.emovie.ui.screen.home.MovieFilterTypes
import com.example.emovie.ui.theme.Primary
import com.example.emovie.ui.theme.Secondary

@Composable
fun ButtonWithBorder(
    onClick: () -> Unit,
    text: String = "",
    enabled: Boolean = true,
    modifier: Modifier = Modifier
        .height(45.dp)
        .fillMaxWidth()
        .padding(horizontal = 10.dp)
) {

    Button(
        onClick = onClick,
        modifier = modifier.border(
            width = 2.dp,
            color = Secondary,
            shape = RoundedCornerShape(50)
        ),
        shape = RoundedCornerShape(50),
        colors = if (enabled) ButtonDefaults.outlinedButtonColors(contentColor = Secondary)
        else ButtonDefaults.buttonColors(contentColor = Primary),
        contentPadding = PaddingValues(0.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(
                vertical = dimensionResource(R.dimen.gap3),
                horizontal = dimensionResource(R.dimen.gap4)
            )
        ) {
            Text(
                text = text,
                color = if (enabled) Primary else Secondary,
                style = MaterialTheme.typography.h4,
                textAlign = TextAlign.Center,
            )
        }
    }

}

@Composable
fun FilterCategoryList(
    onClickItem: (String) -> Unit,
    categoryList: Map<MovieFilterTypes, String> = emptyMap(),
) {
    var selectedOption by remember {
        mutableStateOf(categoryList.firstNotNullOf { (url, category) -> url.url })
    }
    val onSelectionChange = { text: String ->
        selectedOption = text
    }
    Row(
        modifier = Modifier.horizontalScroll(rememberScrollState())
    ) {
        categoryList.forEach { (url, category) ->
            ButtonWithBorder(
                onClick = {
                    onSelectionChange(url.url)
                    onClickItem(url.url)
                },
                text = category,
                enabled = url.url == selectedOption
            )
            Spacer(modifier = Modifier.width(dimensionResource(R.dimen.gap2)))

        }
    }
}
