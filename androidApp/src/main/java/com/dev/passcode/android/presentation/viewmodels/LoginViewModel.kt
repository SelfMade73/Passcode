package com.dev.passcode.android.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dev.passcode.android.platform.EventHandler
import com.dev.passcode.android.presentation.screens.login.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LoginViewModel : ViewModel(), EventHandler<LoginEvent> {

    private val _viewState = MutableStateFlow(LoginViewState())
    val viewState: StateFlow<LoginViewState> = _viewState


    override fun obtainEvent(event: LoginEvent) {
        when (event) {
            is ActionClicked -> switchAction()
            is EmailChanged -> emailChanged(event)
            is PasswordChanged -> passwordChanged(event)
            is RememberMeChanged -> rememberMeChanged(event)
            is PasswordConfirmChanged -> passwordConfirmChanged(event)
        }

    }

    private fun passwordConfirmChanged(confirmChanged: PasswordConfirmChanged) {
        val newConfirmPassword = confirmChanged.passwordConfirmValue
        if (viewState.value.passwordValue != newConfirmPassword) {
            _viewState.value = _viewState.value.copy(passwordValue = newConfirmPassword)
        }
    }

    private fun rememberMeChanged(rememberMeChanged: RememberMeChanged) {
        _viewState.value =
            _viewState.value.copy(rememberMeChecked = rememberMeChanged.checked)
    }

    private fun passwordChanged(passwordChanged: PasswordChanged) {
        val newPassword = passwordChanged.passwordValue
        if (viewState.value.passwordValue != newPassword) {
            _viewState.value = _viewState.value.copy(passwordValue = newPassword)
        }
    }

    private fun switchAction() {
        when (_viewState.value.loginState) {
            LoginState.SIGN_UP -> _viewState.value =
                _viewState.value.copy(loginState = LoginState.SIGN_IN)
            LoginState.SIGN_IN -> _viewState.value =
                _viewState.value.copy(loginState = LoginState.SIGN_UP)
            LoginState.FORGOT -> TODO()
        }
    }

    private fun emailChanged(emailChanged: EmailChanged) {
        val newEmail = emailChanged.emailValue
        if (viewState.value.emailValue != newEmail) {
            _viewState.value = _viewState.value.copy(emailValue = newEmail)
        }
    }

}