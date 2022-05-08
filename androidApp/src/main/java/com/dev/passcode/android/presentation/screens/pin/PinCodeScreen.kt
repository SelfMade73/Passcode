package com.dev.passcode.android.presentation.screens.pin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.dev.passcode.android.R
import com.dev.passcode.android.di.loginKodein
import com.dev.passcode.android.presentation.nav.NavigationTree
import com.dev.passcode.android.presentation.ui.components.ClassicRoundedButton
import com.dev.passcode.android.presentation.ui.theme.AppTheme
import com.dev.passcode.android.presentation.ui.views.PinCodeView
import com.dev.passcode.android.presentation.viewmodels.PinCodeViewModel
import com.dev.passcode.android.presentation.viewmodels.PinCodeViewModelFactory
import org.kodein.di.generic.instance

@Composable
fun PinCodeScreen(
    navController: NavController,
) {
    val factory by loginKodein.instance<PinCodeViewModelFactory>()
    val screenViewModel: PinCodeViewModel = viewModel(factory = factory)
    val state = screenViewModel.state.collectAsState()
    LazyColumn(
        contentPadding = PaddingValues(
            start = 16.dp, end = 16.dp
        ),
        modifier = Modifier
            .fillMaxSize()
            .background(
                AppTheme.colors.primaryBackground
            ),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            PinCodeView(viewModel = screenViewModel)
        }
        item {
            ClassicRoundedButton(
                onClick = {
                    navController.navigate(NavigationTree.LoginScreen.screenName)
                },
                isEnabled = state.value == PinCodeState.DONE,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp, horizontal = 48.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.continue_hint),
                    style = TextStyle(
                        color = AppTheme.colors.primaryTextInvertColor
                    ),
                    textAlign = TextAlign.Center
                )
            }
        }
    }

}