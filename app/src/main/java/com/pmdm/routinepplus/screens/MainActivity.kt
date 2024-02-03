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
import com.pmdm.routinepplus.ui.theme.RoutinePPLUSTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoutinePPLUSTheme {
                val navigationController = rememberNavController()


                requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

                NavHost(
                    navController = navigationController,
                    startDestination = "LoginScreen"
                ) {
                    composable("loginScreen"){ SingInScreen(navController = navigationController)}
                    composable("dashBoard"){ Dashboard(navigationController) }
                    composable("exercisesScreen"){ Exercises(navigationController) }
                    composable("routineday"){ RoutineDay(navigationController) }
                    composable("routinemonth"){ RoutineMonth(navigationController) }
                }
            }
        }
    }
}
