package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.*
import com.example.myapplication.ui.screens.LoginScreen
import com.example.myapplication.ui.screens.SignUpScreen
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Edge-to-edge layout
        enableEdgeToEdge()

        setContent {
            MyApplicationTheme {

                // Simple screen state: "login" or "signup"
                var currentScreen by remember { mutableStateOf("login") }

                when (currentScreen) {

                    "login" -> LoginScreen(
                        onBackClick = {
                            // Exit app when back is pressed on login
                            finish()
                        },
                        onLoginSuccess = {
                            // TODO: Navigate to home/dashboard screen later
                            // For now, do nothing or log
                        },
                        onSignUpClick = {
                            // Switch to the sign-up screen
                            currentScreen = "signup"
                        }
                    )

                    "signup" -> SignUpScreen(
                        onBackClick = {
                            // Go back to login
                            currentScreen = "login"
                        },
                        onSignUpSuccess = {
                            // After successful signup, return to login
                            // (You could also auto-login here)
                            currentScreen = "login"
                        }
                    )
                }
            }
        }
    }
}