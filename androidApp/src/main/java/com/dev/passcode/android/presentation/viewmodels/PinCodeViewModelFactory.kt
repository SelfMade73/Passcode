package com.dev.passcode.android.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dev.passcode.android.domain.PinCodeStatusInteractor

class PinCodeViewModelFactory(
    private val pinCodeStatusInteractor: PinCodeStatusInteractor
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PinCodeViewModel::class.java)) {
            return PinCodeViewModel(pinCodeStatusInteractor) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}