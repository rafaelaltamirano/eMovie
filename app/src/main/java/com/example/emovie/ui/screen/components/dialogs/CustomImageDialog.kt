package com.example.emovie.ui.screen.components.dialogs

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.emovie.R
import com.example.emovie.ui.screen.components.OutlineButton
import com.example.emovie.ui.theme.Primary
import com.example.emovie.ui.theme.Secondary


@Composable
fun CustomImageDialog(
    show: Boolean = false,
    title: String = "",
    message: String = "",
    @DrawableRes image: Int = R.drawable.ic_cut_logo,
    onDismiss: () -> Unit,
) {
    if (!show) return
    else {
        Dialog(
            onDismissRequest = {
                onDismiss()
            }) {
            Card(
                elevation = 8.dp,
                shape = RoundedCornerShape(8.dp),
                contentColor = Secondary
            ) {

                Column(
                    Modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState())
                        .padding(dimensionResource(R.dimen.gap4)),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = title,
                        color = Primary,
                        style = MaterialTheme.typography.h1,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.W700
                    )

                    Spacer(modifier = Modifier.height(30.dp))

                    Icon(
                        painterResource(image),
                        tint = Primary,
                        contentDescription = "logo",
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(22.dp))

                    Text(
                        text = message,
                        color = Primary,
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.subtitle2
                    )
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCustomImageDialog() {
    CustomImageDialog(true, "Titulo", "hola", onDismiss = {})
}


