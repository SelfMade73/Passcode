package com.dev.passcode.android.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.dev.passcode.android.domain.PinCodeStatus
import com.dev.passcode.android.domain.PinCodeStatusInteractor
import com.dev.passcode.android.platform.EventHandler
import com.dev.passcode.android.presentation.screens.pin.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PinCodeViewModel(
    private val pinCodeInteractor: PinCodeStatusInteractor
) : ViewModel(), EventHandler<PinCodeEvent> {

    private val type: PinCodeViewType =
        if (pinCodeInteractor.getPinCodeStatus() == PinCodeStatus.EXISTS) {
            PinCodeViewType.PIN_ENTER
        } else PinCodeViewType.PIN_CREATE


    private val _dots = MutableStateFlow(Array(FULL_PIN) { false })
    val dots: StateFlow<Array<Boolean>> = _dots

    private var _currentDigits = mutableListOf<PinCodeSymbol>()

    private val _state = MutableStateFlow(PinCodeState.ENTER)
    val state: StateFlow<PinCodeState> = _state

    private val _clientName = MutableStateFlow("Aleksey")
    val clientName: StateFlow<String> = _clientName


    val buttons = listOf(
        listOf(PinCodeSymbol.ONE, PinCodeSymbol.TWO, PinCodeSymbol.THREE),
        listOf(PinCodeSymbol.FOUR, PinCodeSymbol.FIVE, PinCodeSymbol.SIX),
        listOf(PinCodeSymbol.SEVEN, PinCodeSymbol.EIGHT, PinCodeSymbol.NINE),
        listOf(PinCodeSymbol.SPACE, PinCodeSymbol.ZERO, PinCodeSymbol.REMOVE)
    )

    override fun obtainEvent(event: PinCodeEvent) {
        when (event) {
            is DigitPressed -> {
                when (type) {
                    PinCodeViewType.PIN_CREATE -> handleEnter(event = event)
                    PinCodeViewType.PIN_ENTER -> handleEnter(event = event)
                }
            }
        }

    }

    private fun handleEnter(event: DigitPressed) {
        if (PinCodeSymbol.REMOVE == event.symbol) {
            _currentDigits.removeLastOrNull()
            _dots.value = _dots.value.copyOf().removeTrue()
        } else {
            _dots.value = _dots.value.copyOf().addTrue()
        }
        if (_dots.value.count { it } == FULL_PIN ){
            _state.value = PinCodeState.DONE
        } else {
            _state.value = PinCodeState.ENTER
        }
    }


    companion object {
        const val FULL_PIN = 4
    }
}

private fun Array<Boolean>.removeTrue(): Array<Boolean> {
    indexOfLast { it }.let { if (it != -1) this[it] = false }
    return this
}

private fun Array<Boolean>.addTrue(): Array<Boolean> {
    indexOfFirst { !it }.let { if (it != -1) this[it] = true }
    return this
}