package com.dev.passcode.android.presentation.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.passcode.android.presentation.screens.pin.PinCodeSymbol
import com.dev.passcode.android.presentation.ui.theme.AppTheme

@Composable
fun ClassicPinSquare(
    pinCodeSymbol: PinCodeSymbol,
    icon : ImageVector? = null,
    onClick: () -> Unit,
) {
    Button(
        modifier = Modifier
            .height(80.dp)
            .width(80.dp),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent
        ),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            disabledElevation = 0.dp,
            hoveredElevation = 0.dp,
            focusedElevation = 0.dp
        ),
        shape = RoundedCornerShape(50),
    ) {
        if (icon == null) {
            Text(
                text = pinCodeSymbol.digit,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    color = AppTheme.colors.headerTextColor,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 40.sp
                )
            )
        } else {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = AppTheme.colors.primaryBrandColor
            )
        }

    }
}