package com.dev.passcode.android.domain

enum class PinCodeStatus{
    EXISTS, NOT_EXISTS
}

interface PinCodeStatusInteractor {
    fun getPinCodeStatus() : PinCodeStatus
}

class PinCodeStatusInteractorImpl() : PinCodeStatusInteractor{
    // TODO mock-implementation
    override fun getPinCodeStatus(): PinCodeStatus = PinCodeStatus.EXISTS

}