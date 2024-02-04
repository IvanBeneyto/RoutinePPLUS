package com.pmdm.routinepplus.screens

import android.content.pm.ActivityInfo
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pmdm.routinepplus.R
import com.pmdm.routinepplus.ui.theme.RoutinePPLUSTheme

class MainActivity : ComponentActivity() {

    companion object {
        val items = listOf(
            Item(
                tittle = "PECHO",
                image = R.drawable.pecho
            ),
            Item(
                tittle = "ESPALDA",
                image = R.drawable.espalda
            ),
            Item(
                tittle = "PIERNAS",
                image = R.drawable.pierna
            ),
            Item(
                tittle = "BRAZOS",
                image = R.drawable.brazo
            ),
            Item(
                tittle = "ABDOMEN",
                image = R.drawable.abdomen
            ),
            Item(
                tittle = "GLUTEOS",
                image = R.drawable.gluteos
            ),
        )
    }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoutinePPLUSTheme {
                val navigationController = rememberNavController()


                requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

                NavHost(
                    navController = navigationController,
                    startDestination = "exercisesScreen"
                ) {
                    composable("loginScreen") { SingInScreen(navController = navigationController) }
                    composable("dashBoard") { Dashboard(navigationController) }
                    composable("exercisesScreen") { Exercises(navigationController) }
                    composable("routineday") { RoutineDay(navigationController) }
                    composable("routinemonth") { RoutineMonth(navigationController) }
                }
            }
        }
    }
}
;