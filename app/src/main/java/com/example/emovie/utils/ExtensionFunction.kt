package com.example.emovie.utils

import android.content.Context
import android.widget.Toast
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.unit.Dp
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*


enum class ToastDuration(val value: Int) {
    SHORT(0),
    LONG(1)
}

fun Context.toast(
    message: String,
    duration: ToastDuration = ToastDuration.LONG
) = Toast.makeText(this, message, duration.value).show()


fun Modifier.dashedBorder(width: Dp, radius: Dp, color: Color) =
    drawBehind {
        drawIntoCanvas {
            val paint = Paint()
                .apply {
                    strokeWidth = width.toPx()
                    this.color = color
                    style = PaintingStyle.Stroke
                    pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
                }
            it.drawRoundRect(
                width.toPx(),
                width.toPx(),
                size.width - width.toPx(),
                size.height - width.toPx(),
                radius.toPx(),
                radius.toPx(),
                paint
            )
        }
    }

fun Float.roundToOneDecimalPlace(): Float {
    val df = DecimalFormat("#.#", DecimalFormatSymbols(Locale.ENGLISH)).apply {
        roundingMode = RoundingMode.HALF_UP
    }
    return df.format(this).toFloat()
}