package com.pmdm.routinepplus.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
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
    val nombre = "Iván Beneyto"
    var edad = 25
    var altura = 186
    var peso = 90
    var diasCompletados = 0

    Column(modifier = Modifier.fillMaxSize()) {
        // Cabecera
        Text(text = "MI SEGUIMIENTO", modifier = Modifier.padding(16.dp))

        // Datos personales
        Row(modifier = Modifier.padding(16.dp)) {
            Text(text = "Nombre:", modifier = Modifier.width(100.dp))
            Text(text = nombre, modifier = Modifier.fillMaxWidth())
        }

        Row(modifier = Modifier.padding(16.dp)) {
            Text(text = "Edad:", modifier = Modifier.width(100.dp))
            OutlinedTextField(
                value = edad.toString(),
                onValueChange = { edad = it.toIntOrNull() ?: edad },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )
        }

        Row(modifier = Modifier.padding(16.dp)) {
            Text(text = "Altura:", modifier = Modifier.width(100.dp))
            OutlinedTextField(
                value = altura.toString(),
                onValueChange = { altura = it.toIntOrNull() ?: altura },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )
        }

        Row(modifier = Modifier.padding(16.dp)) {
            Text(text = "Peso:", modifier = Modifier.width(100.dp))
            OutlinedTextField(
                value = peso.toString(),
                onValueChange = { peso = it.toIntOrNull() ?: peso },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )
        }

        // Barra de progreso
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "DÍAS COMPLETADOS:", modifier = Modifier.width(100.dp))
            LinearProgressIndicator(
                progress = diasCompletados.toFloat() / 5,
                modifier = Modifier.fillMaxWidth()
            )
        }

        // Botón para aumentar días completados
        Button(
            onClick = { diasCompletados += 1 },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp)
        ) {
            Text(text = "AÑADIR DÍA COMPLETADO")
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
                navController.navigate("exercisesScreen")
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
                navController.navigate("routinemonth")
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

