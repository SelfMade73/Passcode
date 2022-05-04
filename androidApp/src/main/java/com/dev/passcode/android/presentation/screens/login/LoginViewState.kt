package com.dev.passcode.android.presentation.screens.login


enum class LoginState{
    SIGN_UP, SIGN_IN, FORGOT
}
data class LoginViewState(
    val loginState: LoginState = LoginState.SIGN_IN,
    val emailValue : String = "",
    val passwordValue : String = "",
    val passwordConfirmValue : String = "",
    val rememberMeChecked : Boolean = false,
    val isLoginProgress : Boolean = false

) {
}