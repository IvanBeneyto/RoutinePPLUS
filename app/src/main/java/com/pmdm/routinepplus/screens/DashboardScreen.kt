package com.pmdm.routinepplus.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun Dashboard(navController: NavController) {
    Scaffold(
        content = { innerPadding ->
            MyMenu(innerPadding)
        },
        bottomBar = { MyBottomNavigation(navController) }
    )
}

@Composable
fun MyMenu(innerPadding: PaddingValues) {
    // Variable para almacenar la edad seleccionada
    var selectedAge by remember { mutableStateOf(18) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(innerPadding),
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
        ) {
            Icon(
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.CenterVertically)
                    .padding(8.dp),
                imageVector = Icons.Default.Person,
                tint = Color(0xFFFFD699),
                contentDescription = ""
            )

            Column(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .align(Alignment.Top)
            ) {
                Text(
                    text = "NOMBRE: Iván Beneyto Collados",
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.Start)
                )

                // Dropdown para la selección de edad
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "EDAD:",
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.Start)
                )
                DropdownMenu(
                    expanded = false,
                    onDismissRequest = { /* No hacemos nada al cerrar */ },
                    modifier = Modifier
                        .align(Alignment.Start)
                ) {
                    // Rango de edades del 18 al 40
                    (18..40).forEach { age ->
                        DropdownMenuItem(onClick = {
                            selectedAge = age
                        }) {
                            Text(text = age.toString())
                        }
                    }
                }
                Text(
                    text = "Edad seleccionada: $selectedAge",
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.Start)
                )
            }
        }
    }
}




@Composable
fun MyBottomNavigation(navController: NavController) {
    var index by rememberSaveable { mutableIntStateOf(0) }
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

