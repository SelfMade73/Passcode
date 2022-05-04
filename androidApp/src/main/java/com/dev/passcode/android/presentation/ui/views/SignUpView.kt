package com.dev.passcode.android.presentation.ui.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.dev.passcode.android.R
import com.dev.passcode.android.presentation.screens.login.LoginViewState
import com.dev.passcode.android.presentation.ui.components.ClassicTextField

@Composable
fun SignUpView(
    viewState: LoginViewState,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onPasswordConfirmChanged: (String) -> Unit,
){
    Column(
        Modifier
            .padding(top = 20.dp)
            .fillMaxWidth(),
    ){
        ClassicTextField(
            value = viewState.emailValue,
            placeholder = stringResource(id = R.string.email_hint),
            onValueChange = onEmailChanged
        )
        Spacer(modifier = Modifier.height(8.dp))
        ClassicTextField(
            value = viewState.passwordValue,
            placeholder = stringResource(id = R.string.password_hint),
            onValueChange = onPasswordChanged,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        Spacer(modifier = Modifier.height(8.dp))
        ClassicTextField(
            value = viewState.passwordValue,
            placeholder = stringResource(id = R.string.password_confirm_hint),
            onValueChange = onPasswordConfirmChanged,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
    }
}