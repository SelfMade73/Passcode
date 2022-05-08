package com.dev.passcode.android.presentation.model

import com.dev.passcode.android.R

//TODO
sealed class PinScreenStringResources(
    val title : Int,
    val subtitle : Int? = null
)

object CreatePassword : PinScreenStringResources(
    title = R.string.enter_pin_code,
    subtitle = R.string.forgot_password_subtitle
)

object ConfirmPassword : PinScreenStringResources(
    title = R.string.confirm_pin_code,
    subtitle = R.string.forgot_password_subtitle
)

object WrongPassword : PinScreenStringResources(
    title = R.string.enter_pin_code,
    subtitle = R.string.passwords_not_equals
)

object NotEqPassword : PinScreenStringResources(
    title = R.string.enter_pin_code,
    subtitle = R.string.enter_pin_code
)
