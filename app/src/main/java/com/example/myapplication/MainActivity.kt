package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
// IMPORT: Connects your main file to the separate login file you created
import com.example.myapplication.ui.screens.LoginScreen
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Configures your app layout to flow safely edge-to-edge behind system bars
        enableEdgeToEdge()

        setContent {
            // 2. Wraps your app in the global Material Design theme
            MyApplicationTheme {

                // 3. Launches your custom styled Login Screen
                LoginScreen(
                    onBackClick = {
                        // Exits the application if the back button is pressed
                        finish()
                    },
                    onLoginSuccess = {
                        // TODO: Handle navigation to your home/dashboard screen later
                    }
                )

            }
        }
    }
}
