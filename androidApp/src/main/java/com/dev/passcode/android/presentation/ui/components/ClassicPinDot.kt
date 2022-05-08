package com.dev.passcode.android.presentation.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dev.passcode.android.presentation.ui.theme.AppTheme

@Composable
fun ClassicPinDot(
    modifier: Modifier = Modifier,
    isEnabled: Boolean = false,
) {
    val backgroundColor = animateColorAsState(if (isEnabled) AppTheme.colors.primaryBrandColor else Color.Transparent)
    Box(
        modifier = modifier
            .size(20.dp)
            .clip(CircleShape)
            .background(backgroundColor.value)
            .border(
                width = 1.dp,
                color = AppTheme.colors.primaryBrandColor,
                shape = CircleShape
            )
    )
}