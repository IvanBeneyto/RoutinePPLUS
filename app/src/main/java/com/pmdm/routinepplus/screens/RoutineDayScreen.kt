package com.pmdm.routinepplus.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun RoutineDay(navController: NavController) {
    Scaffold(
        content = { innerPadding ->
            RutinaDias(innerPadding)
        },
        bottomBar = { MyBottomNavigation(navController) }
    )
}

@Composable
fun RutinaDias(innerPadding: PaddingValues) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "MI RUTINA (DÍAS)", modifier = Modifier.padding(16.dp))

        LazyColumn {
            items(5) { dia ->
                DiaRutina(dia = dia + 1)
            }
        }
    }
}

@Composable
fun DiaRutina(dia: Int) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
        .padding(bottom = 56.dp)){
        Text(text = "DÍA $dia", modifier = Modifier.padding(bottom = 8.dp))

        Column(modifier = Modifier.fillMaxWidth()) {
            Row {
                Text(text = "EJERCICIO", modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
                Text(text = "SERIES", modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
                Text(text = "PESO", modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
            }

            repeat(5) {
                Row {
                    var ejercicio by remember { mutableStateOf("") }
                    OutlinedTextField(
                        value = ejercicio,
                        onValueChange = { ejercicio = it },
                        modifier = Modifier.weight(1f)
                    )

                    var series by remember { mutableStateOf("") }
                    OutlinedTextField(
                        value = series,
                        onValueChange = { series = it },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.weight(1f)
                    )

                    var peso by remember { mutableStateOf("") }
                    OutlinedTextField(
                        value = peso,
                        onValueChange = { peso = it },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

