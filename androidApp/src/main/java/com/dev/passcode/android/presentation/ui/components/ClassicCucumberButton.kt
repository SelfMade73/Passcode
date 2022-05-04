package com.dev.passcode.android.presentation.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.passcode.android.presentation.ui.theme.AppTheme

@Composable
fun ClassicCucumberButton(
    onClick : () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled : Boolean = true,
    content: @Composable RowScope.() -> Unit
){
    Column {
        Button(
            enabled = isEnabled,
            onClick = onClick,
            modifier = modifier,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = AppTheme.colors.primaryBrandColor,
                disabledBackgroundColor = AppTheme.colors.primaryDisabledColor
            ),
            shape = RoundedCornerShape(4.dp),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 8.dp
            ),
            content = content
        )
    }
}