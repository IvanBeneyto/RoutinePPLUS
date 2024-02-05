package com.pmdm.routinepplus.screens

import android.widget.Toast
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.pmdm.routinepplus.R


@Composable
fun Dashboard(navController: NavController) {
    Scaffold(
        content = { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xffe8e8e8))  // Add background color here
            ) {
                MyMenu(innerPadding, navController)
            }
        },
        bottomBar = { MyBottomNavigation(navController) }
    )
}

@Composable
fun MyMenu(innerPadding: PaddingValues, navController: NavController) {
    var edad by rememberSaveable { mutableStateOf("") }
    var altura by rememberSaveable { mutableStateOf("") }
    var peso by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(innerPadding),
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 6.dp)
                .padding(end = 6.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Button(
                onClick = {
                    navController.navigate("login_screen")
                },
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White, // Color del texto
                    containerColor = Color(0xFFD32F2F) // Color del fondo
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Salir de la app")
            }
        }
        Image(
            modifier = Modifier
                .size(250.dp)
                .align(Alignment.CenterHorizontally)
                .clip(RoundedCornerShape(600.dp))
                .padding(8.dp),
            painter = painterResource(id = R.drawable.foto_dash), // Especifica la imagen a mostrar
            contentDescription = "Descripción de la imagen" // Describe la imagen para la accesibilidad
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "NOMBRE:  Iván Beneyto Collados",
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 25.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "EDAD:  25",
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 25.dp)
            )


        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "ALTURA:  186cm",
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 25.dp)
            )


        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Peso:  90 Kg",
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 25.dp)
            )


        }
        val context = LocalContext.current
        var progressCount: Int by remember { mutableStateOf(0) }
        var progress by remember { mutableStateOf(0f) }


        when (progressCount) {
            0 -> progress = 0.0f
            1 -> progress = 0.1f
            2 -> progress = 0.2f
            3 -> progress = 0.3f
            4 -> progress = 0.4f
            5 -> progress = 0.5f
            6 -> progress = 0.6f
            7 -> progress = 0.7f
            8 -> progress = 0.8f
            9 -> progress = 0.9f
            10 -> progress = 1.0f
        }

        val size by animateFloatAsState(
            targetValue = progress,
            tween(
                durationMillis = 1000,
                delayMillis = 100,
                easing = LinearOutSlowInEasing
            )
        )
        Text(
            text = "DIAS COMPLETADOS:", // Adjust text style as needed
            modifier = Modifier
                .padding(top = 50.dp)
                .padding(start = 110.dp) // Add spacing below the title
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp, start = 30.dp, end = 30.dp)
        ) {

            // for the text above the progressBar
            Row(
                modifier = Modifier
                    .widthIn(min = 30.dp)
                    .fillMaxWidth(size),
                horizontalArrangement = Arrangement.End
            ) {
                Text(text = "$progress")
            }
            // Progress Bar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(17.dp)
            ) {
                // for the background of the ProgressBar
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(9.dp))
                        .background(Color(0xFFFF09B3E4))
                )
                // for the progress of the ProgressBar
                Box(
                    modifier = Modifier
                        .fillMaxWidth(size)
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(9.dp))
                        .background(Color(0xFFFFD699))
                        .animateContentSize()
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // decrease button
                OutlinedButton(
                    onClick = {
                        if (progressCount > 0) {
                            progressCount -= 2
                        } else {
                            Toast.makeText(context, "No puedes quitar más dias", Toast.LENGTH_SHORT)
                                .show()
                        }
                    },
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color.White, // Text color
                        containerColor = Color(0xFFFF09B3E4) // Background color
                    )
                ) {
                    Text(text = "Quitar día")
                }
                // increase Button
                Button(
                    onClick = {
                        if (progressCount < 10) {
                            progressCount += 2
                        } else {
                            Toast.makeText(
                                context,
                                "No puedes superar más dias",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White, // Text color
                        containerColor = Color(0xFFFFD699) // Background color
                    )
                ) {
                    Text(text = "Día Completado")
                }
            }
        }
    }
}


@Composable
fun MyBottomNavigation(navController: NavController) {
    var index by rememberSaveable { mutableIntStateOf(3) }
    NavigationBar(
        containerColor = Color(
            android.graphics.Color.parseColor(
                "#FF09B3E4"
            )
        ),
    ) {
        NavigationBarItem(
            selected = index == 0,
            onClick =
            {
                index = 0
                navController.navigate("exercises_screen")
            },
            icon = {
                Icon(
                    modifier = Modifier.size(35.dp),
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Home Icon",
                    tint = Color.White
                )
            },
        )
        NavigationBarItem(
            selected = index == 1,
            onClick = {
                index = 1

                navController.navigate("dashboard")
            },
            icon = {
                Icon(
                    modifier = Modifier.size(35.dp),
                    imageVector = Icons.Default.Home,
                    tint = Color.White,
                    contentDescription = "Fav Icon"
                )
            },
        )
        NavigationBarItem(
            selected = index == 2,
            onClick = {
                index = 2
                navController.navigate("routine_month_screen")
            },
            icon = {
                Icon(
                    modifier = Modifier.size(35.dp),
                    imageVector = Icons.Default.CalendarMonth,
                    contentDescription = "Person Icon",
                    tint = Color.White,
                )
            },
        )
    }
}

