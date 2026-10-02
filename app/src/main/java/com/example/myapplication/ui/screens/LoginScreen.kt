package com.example.myapplication.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(onBackClick: () -> Unit, onLoginSuccess: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Scaffold(
    ) { innerPadding ->

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            color = MaterialTheme.colorScheme.background // Resolves to ModernBackgroundDark
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                // MODERN UPDATE: Card uses surfaceContainer instead of surfaceVariant
                Surface(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .wrapContentHeight(),
                    shape = RoundedCornerShape(24.dp),
                    color = MaterialTheme.colorScheme.background, // Resolves to ModernSurfaceContainerDark
                    tonalElevation = 0.dp // Modern design relies on surfaceContainer instead of tint overlays
                ) {
                    Column(
                        modifier = Modifier
                            .padding(24.dp)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Text(
                            text = "Sign In",
                            style = MaterialTheme.typography.headlineMedium,
                            // MODERN UPDATE: Reads content text color over the container surface safely
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        // Email Field (Automatically styled via MaterialTheme definitions)
                        // Email Field
                        OutlinedTextField(
                            value = email,
                            onValueChange = { email = it },
                            label = { Text("Email Address") },
                            modifier = Modifier.fillMaxWidth(),
                            singleLine = true,
                            shape = RoundedCornerShape(24.dp) // Makes the edges highly rounded
                        )

                        // Password Field
                        OutlinedTextField(
                            value = password,
                            onValueChange = { password = it },
                            label = { Text("Password") },
                            visualTransformation = PasswordVisualTransformation(),
                            modifier = Modifier.fillMaxWidth(),
                            singleLine = true,
                            shape = RoundedCornerShape(24.dp) // Makes the edges highly rounded
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        // Login Button (Automatically styles itself using ModernPrimaryDark & ModernOnPrimaryDark)
                        Button(
                            onClick = onLoginSuccess,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp),
                            shape = RoundedCornerShape(12.dp),
                            // CUSTOM COLORS: Force the button background to be black
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF232323),       // Button background color
                                contentColor = Color.White,         // Text/Icon color inside the button
                                disabledContainerColor = Color.DarkGray, // Optional: Color when button is disabled
                                disabledContentColor = Color.LightGray  // Optional: Text color when button is disabled
                            )
                        ) {
                            Text("Login", style = MaterialTheme.typography.labelLarge)
                        }
                    }
                }
            }
        }
    }
}
