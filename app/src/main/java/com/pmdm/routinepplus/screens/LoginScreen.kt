package com.pmdm.routinepplus.screens

import android.annotation.SuppressLint
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.pmdm.routinepplus.R
import com.pmdm.routinepplus.ui.theme.RoutinePPLUSTheme


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnrememberedMutableState")
@Composable
fun SingInScreen(navController: NavHostController) {
    var username by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var isPasswordVisible by remember {
        mutableStateOf(false)
    }

    var errorMessage by remember { mutableStateOf<String?>(null) }

    val isFormValid by derivedStateOf {
        username.isNotBlank() && password.length >= 7
    }

    Scaffold() {
        Column(
            Modifier
                .fillMaxSize()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "App LOGO",
                modifier = Modifier
                    .weight(1f)
                    .size(350.dp)
            )

            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1.5f)
                    .padding(3.dp),
                shape = RoundedCornerShape(24.dp),
            ) {
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(30.dp)
                ) {
                    Text(
                        text = "INICIO DE SESIÓN",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 25.sp,
                        color = Color(android.graphics.Color.parseColor("#FFFFD699")),

                        )
                    Column(
                        Modifier
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = username,
                            onValueChange = { username = it },
                            label = { Text(text = "Username") },
                            singleLine = true,
                            trailingIcon = {
                                if (username.isNotBlank())
                                    IconButton(onClick = { username = "" }) {
                                        Icon(
                                            imageVector = Icons.Filled.Clear,
                                            contentDescription = ""
                                        )
                                    }
                            }
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = password,
                            onValueChange = { password = it },
                            label = { Text(text = "Password") },
                            singleLine = true,
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Password,
                                imeAction = ImeAction.Done
                            ),
                            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                            trailingIcon = {
                                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                                    Icon(
                                        imageVector = if (isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                                        contentDescription = "Password visible"
                                    )
                                }
                            }
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            onClick = {
                                if (username.length > 20) {
                                    errorMessage = "El nombre de usuario no puede tener más de 20 caracteres"
                                } else if (password.length > 20) {
                                    errorMessage = "La contraseña no puede tener más de 20 caracteres"
                                } else if (username.length < 4) {
                                    errorMessage = "Tu nombre de usuario debe ser de al menos 4 caracteres"
                                } else if (password.length < 8) {
                                    errorMessage = "La contraseña no puede tener menos de 8 caracteres"
                                } else {
                                    errorMessage = null
                                    if(isValidCredentialsStudent(username, password)) {
                                        errorMessage = null
                                        // onLoginClicked(username, password)
                                        navController.navigate(NavigationActivity.Dashboard.route)
                                    } else {
                                        errorMessage = "Credenciales de usuario no válidas"
                                    }

                                }
                            },
                            enabled = isFormValid,
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Text(text = "Acceder")
                        }
                    }
                    errorMessage?.let {
                        Text(
                            text = it,
                            color = Color.Red,
                            modifier = Modifier
                                .padding(top = 8.dp)
                                .fillMaxWidth()
                                .alpha(0.8f)
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SingInPreview() {
    RoutinePPLUSTheme {
        var isAppClosed by remember {
            mutableStateOf(false)
        }
        val navController = rememberNavController()
        SingInScreen(navController = navController)
    }
}
