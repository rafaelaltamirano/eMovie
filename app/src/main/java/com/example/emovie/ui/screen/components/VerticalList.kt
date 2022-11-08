package com.example.emovie.ui.screen.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.domain.model.Movie
import com.example.emovie.R
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode

@Composable
fun VerticalList(items: List<Movie>,
                 onClick: ((Movie) -> Unit)) {
    val itemSize: Dp =
        (LocalConfiguration.current.screenWidthDp.dp / 2) - dimensionResource(R.dimen.gap4)
    FlowRow(
        modifier = Modifier.padding(vertical = dimensionResource(R.dimen.gap4)),
        mainAxisSize = SizeMode.Expand,
        mainAxisAlignment = FlowMainAxisAlignment.SpaceBetween,
    ) {
        for (item in items) {
            MovieCard(
                modifier = Modifier
                    .width(itemSize)
                    .height(205.dp),
                item = item,
                onClick = {onClick(item)}
            )
        }
    }
}