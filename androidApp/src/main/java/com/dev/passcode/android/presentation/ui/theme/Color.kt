package com.dev.passcode.android.presentation.ui.theme

import androidx.compose.ui.graphics.Color

data class Colors(
    val primaryBackground: Color,
    val secondaryBackground: Color,
    val headerTextColor: Color,
    val primaryTextColor: Color,
    val primaryTextInvertColor : Color,
    val primaryBrandColor : Color,
    val primaryWarningColor : Color,
    val primaryDisabledColor : Color
)

val lightPalette = Colors(
    primaryBackground = Color(0xFFFFFFFF),
    secondaryBackground = Color(0xFFD0CCC7),
    headerTextColor = Color(0xFF000000),
    primaryTextColor =  Color(0xFF59442B),
    primaryTextInvertColor = Color(0xFFFFFFFF),
    primaryBrandColor = Color(0xFFF44336),
    primaryWarningColor = Color(0XFFFFA726),
    primaryDisabledColor = Color(0XFFBDBDBD)
)