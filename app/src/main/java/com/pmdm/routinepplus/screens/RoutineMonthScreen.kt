package com.pmdm.routinepplus.screens

import android.content.SharedPreferences
import android.preference.PreferenceManager
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController // Para Compose 1.2.0 y superior



@Composable
fun myMenuRoutine(navController: NavController) {
    // Importamos el contexto de la aplicación
    val context = LocalContext.current

    // Obtenemos las preferencias compartidas
    val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    // Recuperamos el mes guardado
    val savedMonth = sharedPreferences.getString("saved_month", "ENERO") ?: "ENERO"
    var month by remember { mutableStateOf(savedMonth) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "MI RUTINA (MES / SEMANAS)",
            modifier = Modifier.padding(top = 16.dp)
        )

        OutlinedTextField(
            value = month,
            onValueChange = {
                month = it
                saveMonth(it, sharedPreferences) // Pasamos las preferencias como parámetro
            },
            label = { Text("Mes") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )



        LazyColumn(
            modifier = Modifier.padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(4) { index ->
                Button(
                    onClick = { navController.navigate("routineday") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFFFD699))
                        .height(70.dp),
                ) {
                    Text(text = "SEMANA ${index + 1}")
                }
            }
        }
    }
}

@Composable
fun RoutineMonth(navController: NavController) {
    Scaffold(
        content = { innerPadding ->
            myMenuRoutine(navController)
        },
        bottomBar = { MyBottomNavigation(navController) }
    )
}

private fun saveMonth(month: String, sharedPreferences: SharedPreferences) {
    with(sharedPreferences.edit()) {
        putString("saved_month", month)
        apply()
    }
}