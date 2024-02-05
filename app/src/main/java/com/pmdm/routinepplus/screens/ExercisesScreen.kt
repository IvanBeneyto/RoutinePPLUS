package com.pmdm.routinepplus.screens

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.pmdm.routinepplus.R


@Composable
fun ExerciseScreen(navController: NavController) {

    Scaffold(
        content = { innerPadding ->
            ExercisesGridView(innerPadding, )
        },
        bottomBar = { MyBottomNavigation(navController) }
    )
}


@Composable
fun ExercisesGridView(innerPadding: PaddingValues) {
    val context = LocalContext.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top = 32.dp) // Margen superior adicional
    ) {
        Text(
            text = "(TOP EJERCICIO CADA GRUPO MUSCULAR)",
            modifier = Modifier.padding(bottom = 16.dp) // Margen inferior del texto
        )

        LazyVerticalGrid(
            modifier = Modifier.padding(8.dp),
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(vertical = 8.dp, horizontal = 16.dp),
            content = {
                items(getExercises()) {
                    ItemExerciseButton(it) {
                        Toast.makeText(context, it.nameExercise, Toast.LENGTH_SHORT).show()
                    }
                }
            })
    }
}

@Composable
fun ItemExerciseButton(exercises: Exercices, onItemSelected: (Exercices) -> Unit) {
    val context = LocalContext.current


    Button(
        onClick = {
            Toast
                .makeText(context, exercises.description, Toast.LENGTH_SHORT).show()
        },
        shape = RoundedCornerShape(18.dp),
        modifier = Modifier
            .width(250.dp)
            .height(150.dp) // Adjust height as needed
    ) {
        Image(
            painter = painterResource(id = exercises.picture),
            contentDescription = "SuperHero Avatar",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
    }

    Text(
        text = exercises.nameExercise,
        modifier = Modifier
            .padding(top = 150.dp)
            .padding(start = 50.dp)
            .clickable {
                Toast
                    .makeText(context, exercises.nameExercise, Toast.LENGTH_SHORT)
                    .show()
            }
    )
}

fun getExercises(): List<Exercices> {
    return listOf(
        Exercices("PECHO", "TOP EJERCICIO \n - PRESS BANCA", R.drawable.pecho),
        Exercices("ESPALDA", "TOP EJERCICIO \n - DOMINADAS", R.drawable.espalda),
        Exercices("PIERNA", "TOP EJERCICIO \n - PESO MUERTO", R.drawable.pierna),
        Exercices("BRAZO", "TOP EJERCICIO \n - CURL Y FONDOS", R.drawable.brazo),
        Exercices("ABDOMEN", "TOP EJERCICIO \n - ELEVACION PIERNAS", R.drawable.abdomen),
        Exercices("GLUTEOS", "TOP EJERCICIO \n - SENTADILLAS", R.drawable.gluteos)
    )
}