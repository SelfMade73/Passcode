package com.dev.passcode.android.presentation.screens.login

sealed class LoginEvent
object ActionClicked : LoginEvent()
data class EmailChanged(val emailValue : String) : LoginEvent()
data class PasswordChanged(val passwordValue : String) : LoginEvent()
data class PasswordConfirmChanged(val passwordConfirmValue : String) : LoginEvent()
data class RememberMeChanged(val checked : Boolean) : LoginEvent()