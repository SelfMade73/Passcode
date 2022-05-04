package com.dev.passcode.android.presentation.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import com.dev.passcode.android.presentation.ui.theme.AppTheme


@Composable
fun ClassicCheckableText(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle(
        color = AppTheme.colors.primaryTextColor
    ),
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ClassicCheckBox(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
        Text(text = text, style = textStyle)
    }
}