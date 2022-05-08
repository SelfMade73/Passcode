package com.dev.passcode.android.presentation.ui.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Backspace
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.passcode.android.presentation.screens.pin.DigitPressed
import com.dev.passcode.android.presentation.screens.pin.PinCodeSymbol
import com.dev.passcode.android.presentation.ui.components.ClassicPinDot
import com.dev.passcode.android.presentation.ui.components.ClassicPinSquare
import com.dev.passcode.android.presentation.ui.theme.AppTheme
import com.dev.passcode.android.presentation.viewmodels.PinCodeViewModel

@Composable
fun PinCodeView(
    viewModel: PinCodeViewModel,
) {
    val dots = viewModel.dots.collectAsState()
    val name by viewModel.clientName.collectAsState()
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = name,
                style = TextStyle(
                    color = AppTheme.colors.primaryTextColor,
                    fontSize = 17.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                ),
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            dots.value.forEach {
                ClassicPinDot(isEnabled = it, modifier = Modifier.padding(8.dp))
            }
        }
        viewModel.buttons.forEach { row ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                row.forEach { button ->
                    val icon = if (button == PinCodeSymbol.REMOVE) {
                        Icons.Filled.Backspace
                    } else null
                    ClassicPinSquare(pinCodeSymbol = button, icon = icon) {
                        viewModel.obtainEvent(DigitPressed(button))
                    }
                }
            }
        }
    }
}