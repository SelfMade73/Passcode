package com.dev.passcode.android.presentation.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dev.passcode.android.presentation.nav.NavigationTree
import com.dev.passcode.android.presentation.screens.login.LoginScreen
import com.dev.passcode.android.presentation.screens.pin.PinCodeScreen

@Composable
fun AppScreen() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavigationTree.SplashScreen.screenName
    ) {
        composable(NavigationTree.SplashScreen.screenName){
            SplashScreen(navController = navController)
        }
        composable(NavigationTree.LoginScreen.screenName){
            LoginScreen(navController = navController)
        }
        composable(NavigationTree.PinScreen.screenName){
            PinCodeScreen(navController = navController)
        }
    }
}