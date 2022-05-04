package com.dev.passcode.android.presentation.screens.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.dev.passcode.android.R
import com.dev.passcode.android.presentation.ui.components.ClassicCucumberButton
import com.dev.passcode.android.presentation.ui.theme.AppTheme
import com.dev.passcode.android.presentation.ui.views.SignInView
import com.dev.passcode.android.presentation.viewmodels.LoginViewModel

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = viewModel()
) {
    val viewState = viewModel.viewState.collectAsState()
    with(viewState.value) {
        LazyColumn(
            contentPadding = PaddingValues(
                start = 16.dp, end = 16.dp
            ),
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                Text(
                    modifier = Modifier.padding(
                        top = 16.dp,
                    ),
                    text = when (loginState) {
                        LoginState.SIGN_UP -> stringResource(id = R.string.sign_up_title)
                        LoginState.SIGN_IN -> stringResource(id = R.string.sign_in_title)
                        LoginState.FORGOT -> stringResource(id = R.string.forgot_password_title)
                    },
                    style = TextStyle(
                        color = AppTheme.colors.primaryTextColor,
                        fontWeight = FontWeight.Bold,
                        fontSize = 40.sp
                    )
                )

            }
            item {
                Row(
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    Text(
                        text = when (loginState) {
                            LoginState.SIGN_UP -> stringResource(id = R.string.sign_up_subtitle)
                            LoginState.SIGN_IN -> stringResource(id = R.string.sign_in_subtitle)
                            LoginState.FORGOT -> stringResource(id = R.string.forgot_password_subtitle)
                        },
                        color = AppTheme.colors.primaryTextColor
                    )
                    if (LoginState.FORGOT != loginState) {
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            modifier = Modifier.clickable {
                                viewModel.obtainEvent(ActionClicked)
                            },
                            text = stringResource(id = R.string.already_have_account),
                            style = TextStyle(
                                color = AppTheme.colors.primaryBrandColor,
                                fontWeight = FontWeight.Medium
                            )
                        )
                    }
                }
            }
            item {
                when(loginState){
                    LoginState.SIGN_UP -> {}
                    LoginState.SIGN_IN -> SignInView(
                        viewState = this@with, onEmailChanged = {
                            viewModel.obtainEvent(EmailChanged(it))
                        }, onPasswordChanged = {
                            viewModel.obtainEvent(PasswordChanged(it))
                        }, onRememberMeChanged = {
                            viewModel.obtainEvent(RememberMeChanged(it))
                        }
                    )
                    LoginState.FORGOT -> TODO()
                }
            }
            item{
                ClassicCucumberButton(
                    onClick = {}, modifier = Modifier.fillMaxWidth()
                ){
                    Text(
                        modifier = Modifier.weight(1F),
                        text = stringResource(id = R.string.continue_hint),
                        style = TextStyle(
                            color = AppTheme.colors.primaryTextInvertColor
                        ),
                        textAlign = TextAlign.Center
                    )
                    Icon(
                        imageVector = Icons.Filled.ArrowForwardIos,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
        }
    }


}
