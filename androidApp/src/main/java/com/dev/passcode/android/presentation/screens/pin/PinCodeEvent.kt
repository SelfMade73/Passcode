package com.dev.passcode.android.presentation.screens.pin

sealed class PinCodeEvent
data class DigitPressed( val symbol : PinCodeSymbol ) : PinCodeEvent()