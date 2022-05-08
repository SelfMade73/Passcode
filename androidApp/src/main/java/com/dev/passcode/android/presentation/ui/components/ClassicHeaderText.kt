package com.dev.passcode.android.presentation.ui.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.dev.passcode.android.presentation.ui.theme.AppTheme

@Composable
fun ClassicHeaderText(
    text : String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        modifier = modifier,
        style = TextStyle(
            color = AppTheme.colors.headerTextColor,
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp
        )
    )
}