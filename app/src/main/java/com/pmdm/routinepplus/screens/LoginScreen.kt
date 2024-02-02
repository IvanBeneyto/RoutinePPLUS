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
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
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

    val isFormValid by derivedStateOf {
        username.isNotBlank() && password.length >= 7
    }

    var isLoginCorrect: Boolean by remember {
        mutableStateOf(false)
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
                    .fillMaxWidth()
                    .weight(1.2f)
                    .clip(
                        RoundedCornerShape(
                            topStart = 30.dp,
                            topEnd = 30.dp
                        )
                    ),

                colors = CardDefaults.cardColors(
                    containerColor = Color(
                        android.graphics.Color.parseColor(
                            "#FF09B3E4"
                        )
                    )
                ),
                shape = RectangleShape
            ) {
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(30.dp)
                ) {
                    Text(
                        modifier = Modifier.align(Alignment.CenterHorizontally),
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
                        TextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(
                                    RoundedCornerShape(
                                        topStart = 15.dp,
                                        topEnd = 15.dp,
                                        bottomEnd = 15.dp,
                                        bottomStart = 15.dp
                                    )
                                ),
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
                        TextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(
                                    RoundedCornerShape(
                                        topStart = 15.dp,
                                        topEnd = 15.dp,
                                        bottomEnd = 15.dp,
                                        bottomStart = 15.dp

                                    )
                                ),
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
                        Text(
                            text = "Usuario y contraseña no correcto",
                            color = if (isLoginCorrect)
                                Color.Red
                            else
                                Color.Transparent

                        )
                        Button(
                            onClick = {
                                if (isValidCredentialsStudent(username, password)) {
                                    // onLoginClicked(username, password)
                                    navController.navigate("Dashboard")
                                } else {
                                    isLoginCorrect = true
                                }
                            },
                            enabled = isFormValid,
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(
                                contentColor = Color(
                                    android.graphics.Color.parseColor(
                                        "#09B3E4"
                                    )
                                ),
                                containerColor = Color(
                                    android.graphics.Color.parseColor(
                                        "#FFD699"
                                    )
                                ),
                                disabledContainerColor = Color(
                                    android.graphics.Color.parseColor(
                                        "#FFEBCD"
                                    )
                                ),
                                disabledContentColor = Color(
                                    android.graphics.Color.parseColor(
                                        "#0CC0DF"
                                    )
                                )
                            )
                        ) {
                            Text(
                                text = "Acceder"
                            )

                        }
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
