package com.example.emovie.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.emovie.R


val Poppins = FontFamily(
    Font(R.font.poppins_regular, FontWeight.W800),
    Font(R.font.poppins_black, FontWeight.W700),
    Font(R.font.poppins_bold, FontWeight.W600),
    Font(R.font.poppins_semi_bold, FontWeight.W500),
    Font(R.font.poppins_medium, FontWeight.W400),
    Font(R.font.poppins_thin, FontWeight.W300),
    Font(R.font.poppins_light, FontWeight.W200)
)

val Typography = Typography(
    h1 = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.W500,
        fontSize = 40.sp,
        letterSpacing = 0.25.sp
    ),
    h2 = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.W800,
        fontSize = 24.sp
    ),
    h3 = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.W600,
        fontSize = 20.sp
    ),
    h4 = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.W400,
        fontSize = 12.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.W800,
        fontSize = 16.sp,
        letterSpacing = 0.15.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp,
        letterSpacing = 0.1.sp
    ),
    body1 = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.W800,
        fontSize = 12.sp,
        letterSpacing = 0.25.sp
    ),
    body2 = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp,
        letterSpacing = 0.25.sp
    ),
    button = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp,
        letterSpacing = 1.25.sp,
    ),
    caption = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.W800,
        fontSize = 12.sp,
        letterSpacing = 0.4.sp,
    ),
    overline = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.W800,
        fontSize = 10.sp,
        letterSpacing = 1.5.sp,
    ),
)