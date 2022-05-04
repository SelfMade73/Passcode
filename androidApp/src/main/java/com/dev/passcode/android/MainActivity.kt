package com.dev.passcode.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dev.passcode.Greeting
import android.widget.TextView
import androidx.activity.compose.setContent
import androidx.compose.runtime.SideEffect
import com.dev.passcode.android.presentation.screens.AppScreen
import com.dev.passcode.android.presentation.ui.theme.AppTheme
import com.dev.passcode.android.presentation.ui.theme.PassCodeTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PassCodeTheme {

                val systemUiController = rememberSystemUiController()
                val primaryBackground = AppTheme.colors.primaryBackground
                SideEffect {
                    systemUiController.setStatusBarColor(
                        color = primaryBackground, darkIcons = false
                    )
                }
                AppScreen()
            }
        }
    }
}
