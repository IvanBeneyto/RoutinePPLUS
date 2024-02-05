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


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoutinePPLUSTheme {
                val navigationController = rememberNavController()


                requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

                NavHost(
                    navController = navigationController,
                    startDestination = "login_screen"
                ) {
                    composable("login_screen") { SingInScreen(navController = navigationController) }
                    composable("dashboard") { Dashboard(navigationController) }
                    composable("exercises_screen") { ExerciseScreen(navigationController) }
                    composable("routine_day_screen") { RoutineDay(navigationController) }
                    composable("routine_month_screen") { RoutineMonth(navigationController) }
                }
            }
        }
    }
}
;