package com.dev.passcode.android.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.dev.passcode.android.presentation.nav.NavigationTree

@Composable
fun SplashScreen(
    navController: NavController
){
    LaunchedEffect(key1 = Unit){
        navController.navigate(NavigationTree.PinScreen.screenName)
    }
}