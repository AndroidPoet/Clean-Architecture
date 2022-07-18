package com.androidpoet.cleanarchitecture.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.androidpoet.cleanarchitecture.R

// Set of Material typography styles to start with

val slackFontFamily =
  FontFamily(
    Font(R.font.lato_bold, weight = FontWeight.Bold),
    Font(R.font.lato_light, weight = FontWeight.Light),
    Font(R.font.lato_regular)
  )

val SlackCloneTypography = Typography(
  defaultFontFamily = slackFontFamily,
  body1 = TextStyle(
    fontFamily = slackFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp
  ),
  button = TextStyle(
    fontFamily = slackFontFamily,
    fontWeight = FontWeight.W500,
    fontSize = 14.sp
  ),
  caption = TextStyle(
    fontFamily = slackFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp
  )


)